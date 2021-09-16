<!--
 * @Author: fangsai li
 * @Date: 2021-09-03 11:35:28
 * @LastEditTime: 2021-09-15 14:15:59
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/App.vue
-->

<template>
<div class="bg">
    <el-container>
        <!-- lift area Aside cv -->
        <el-aside>
            <div class="details">
                <div class="toutou"></div>
                <div class="d-name">
                    <div class="l-name">Fangsai Li</div>
                    <div class="sm-name">
                        <span>Undergraduate </span>
                        <span>in KCL</span>
                    </div>
                </div>
                <div class="d-links">
                    <ul>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>

                        <li @click="opnelink()"></li>
                        <li></li>
                    </ul>
                </div>
                <div class="d-self">
                    <div class="d-title">What’s in My Mind</div>
                    <div class="d-content">
                        We can develop and design anything beyond your ima gination. About
                        our work, we don’t say anything because our work speaks. For
                        more, you can ask our clients and they will tell you how much
                        satisfied they are with our services. So, what are you waiting
                        for?
                    </div>
                </div>
                <div class="d-downloadcv">
                    <button class="downloadcv" @click="downloadcv()">
                        <span class="down">

                        </span>
                        <span>Download CV</span>
                    </button>
                </div>
            </div>
        </el-aside>

        <!-- right area Menu and Main-->
        <el-container class="right-area">
            <!-- menu -->
            <el-header>
                <ul class="menulist">
                    <li v-for="(item, i) in menulist" key="i" @click="menuclick(item,i)"><span>{{item.name}}</span></li>
                    <li class="l-search"></li>
                    <li class="l-menu"></li>
                </ul>
            </el-header>
            <el-main>
                <router-view></router-view>

            </el-main>
            <el-footer>
                <div>
                    © 2021 <span style="color:#2196f3">Fangsai Li</span>. All rights reserved. Design by <span style="color:#ef5350">webstrot.&nbsp </span>/&nbsp&nbsp<a id="Icplink" @click="toIcp()">鄂ICP备2021015598号-1</a>
                </div>
            </el-footer>
        </el-container>
    </el-container>
    
</div>
</template>

<script>
import axios from "axios"
export default {
    data() {
        return {
            description: [],
            menulist: [{
                name: 'Home',
                path: '/'
            }, {
                name: 'About',
                path: '/index/about'
            }, {
                name: 'Skills',
                path: '/index/skills'
            }, {
                name: 'Education',
                path: '/index/education'
            }, {
                name: 'Portfolio',
                path: '/index/portifio'
            }, {
                name: 'Experience',
                path: '/index/experience'
            }, {
                name: 'Contact',
                path: '/index/contact'
            }, ]
        };
    },
    mounted() {
        this.tohome();
        // http://ip-api.com/json/77.88.61.200?lang=zh-CN
        // var url = this.getip();
        var position = this.getip();

        // this.setTime(position);
        setTimeout(() => {
            console.log(this.description)
            axios.post(
                '/watch/time',
                JSON.stringify(this.description)

            ).then((res) => {
                console.log(res);
            }).catch((err) => {
                console.log(err);
            });

        }, 5000);
    },

    methods: {
        async setTime(position) {
            await axios.get(
                '/watch/time'

            ).then((res) => {
                console.log(res);
            }).catch((err) => {
                console.log(err);
            });
        },
        async getip() {
            axios.get(
                '/watch/ip',

            ).then((res) => {
                console.log(res);

                axios.get("http://ip-api.com/json/" + res.data + "?lang=zh-CN").then((res) => {
                    this.description = JSON.stringify(res.data)
                }).catch((err) => {
                    this.description = err.data

                });

            }).catch((err) => {
                console.log(err);
                return err.data;
            });
        },
        opnelink(link) {
            window.open("https://www.linkedin.com/in/%E6%96%B9%E8%B5%9B-%E6%9D%8E-569878204");

        },
        toIcp() {
            window.open("http://beian.miit.gov.cn/")
        },
        tohome() {
            var lst = document.querySelector('.menulist');
            var lis = lst.querySelectorAll('li');

            for (var i = 0; i < lis.length; i++) {
                lis[i].style.backgroundColor = '';
                lis[i].style.transform = 'scale(1)';
            }
            lis[0].style.backgroundColor = '#2196f3';
            lis[0].style.transform = 'scale(1.2)';
        },

        downloadcv() {
            let a = document.createElement('a')
            a.href = "http://47.97.222.87:8088/file/download?fileName=李方赛的简历.docx"
            a.click();

        },

        menuclick(value, index) {
            var lst = document.querySelector('.menulist');
            var lis = lst.querySelectorAll('li');
            for (var i = 0; i < lis.length; i++) {
                lis[i].style.backgroundColor = '';
                lis[i].style.transform = 'scale(1)';
            }

            lis[index].style.backgroundColor = '#2196f3';
            lis[index].style.transform = 'scale(1.2)';
            this.$router.push(value.path);
        }
    },
}
</script>

<style>
@import url("assets/css/leftarea.css");
@import url("assets/css/menu.css");
@import url("views/css/nomalize.css");
@import url("assets/font/merienda/Merienda.css");

#Icplink {
    font-size: 12px;
}

#Icplink:hover {
    color: #797979;
}

.right-area {
    height: 100vh;
    overflow: scroll;
}

.bg {
    background-color: #111111;
}

.el-header,
.el-footer {

    padding: 0;
    margin: 2vw 2vw 2vw 0px;
    background-color: #222222;
    color: #ffffff;
    text-align: center;

}

.el-aside {
    width: 20%;
    margin: 2vw;
    background-color: #222222;

    text-align: center;
}

.el-main {
    margin-right: 2vw;
    background-color: #222222;
    color: #ffffff;
    text-align: center;
    line-height: 160px;
    font: 900;
    font-size: 20px;

}

html {
    min-width: 800px;
}

#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    min-width: 800px;
}
</style>
