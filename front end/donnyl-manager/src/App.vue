<  !--
 * @Author: your name
 * @Date: 2021-09-15 14:32:48
 * @LastEditTime: 2021-09-22 15:43:02
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /front end/donnyl-manager/src/App.vue
-->
<template>
<div id="nav">
    <el-container>
        <!-- lift area Aside cv -->
        <el-aside>
            <div class="details">
                <div class="toutou"></div>
                <div class="d-name">ç
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
                    <li class="l-menu" @click="showlogin=!showlogin"></li>

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

    <el-drawer v-model="showlogin" custom-class="demo-drawer" ref="drawer">
        <div class="demo-drawer__content">
            <el-form :model="form">
                <el-form-item label="Name" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Password" :label-width="formLabelWidth">
                    <el-input v-model="form.password" autocomplete="off" show-password></el-input>
                </el-form-item>

            </el-form>
            <div class="demo-drawer__footer">

                <el-button type="primary" @click="login()">Confirm</el-button>
                <el-button type="primary" @click="find()">Find</el-button>
            </div>
        </div>
    </el-drawer>
    <div id="float-window" @click="changecondition()" class="big-float-window">
        <div id="ft-wd-ct" >
            <div style="font-size:18px; color:#0917FF; font-family: 'Merienda';font-weight:900">Welcome My Web!</div>
            <div >Watch Times:{{sumwatchtimes}}</div>
            <div >Contact Times:{{sumcontacttimes}}</div>
            <div style="line-height:100px; color:#ccc; font-size:16px">Click  narrow</div>
        </div>
    </div>

</div>
</template>

<script>
import axios from "axios"
import {
    Mousewheel
} from 'element-plus';
import { h } from '@vue/runtime-core';
// const transformResponse = function (res) {
//     res = res.replace(/\"token\":(\d+)/g, '"token":"$1"')
//     return JSON.parse(res)
// }

// const instance = axios.create({
//   baseURL: 'http://localhost:8088',
//   transformResponse 
// })

export default {
    data() {
        return {
            // 鼠标位置
            x: null,
            y: null,
            // 浮动标签
            fwindow: null,
            // 计时器是否在工作
            moveevent: true,
            // 计时器的指针
            timeout: null,
            // 监控是否需要移动
            canmove: false,
            //touch时间
            touchtime: 0,
            //windowsize window is big or small
            windowbigsize: true,


            sumwatchtimes:0,
            sumcontacttimes:0,

            


            form: {
                name: '',
                password: '',
            },
            formLabelWidth: '80px',
            showlogin: false,
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
            }, ],
            timer: null,
        };
    },

    watch: {
        // deep watch eg.data is "form.id"
        // "canmove": {
        //     handler(newVal, oldVal) {
        //         if (newVal == true) {
        //             console.log('change l ');

        //             let cssStr = "overflow-y: hidden; height: 100%;";

        //             document.getElementsByTagName('html')[0].style.cssText = cssStr;

        //             document.body.style.cssText = cssStr;

        //         } else {
        //             console.log('change r ');
        //             let cssStr = "overflow-y: auto; height: auto;";

        //             document.getElementsByTagName('html')[0].style.cssText = cssStr;

        //             document.body.style.cssText = cssStr;

        //         }

        //         // 下面需要这两行代码，兼容不同浏览器

        //         document.body.scrollTop = this.pageScrollYoffset;

        //         window.scroll(0, this.pageScrollYoffset);

        //     },
        //     deep:true,
        //     immediate:true
        // },
        // canmove(newVal, oldVal) {
        //     if (newVal == true) {
        //         console.log('change true ');

        //         let cssStr = "overflow: hidden; ";

        //         document.getElementsByTagName('html')[0].style.cssText = cssStr;

        //         document.body.style.cssText = cssStr;

        //     } else {
        //         console.log('change false ');
        //         let cssStr = "overflow: auto;";

        //         document.getElementsByTagName('html')[0].style.cssText = cssStr;

        //         document.body.style.cssText = cssStr;

        //     }

        //     // 下面需要这两行代码，兼容不同浏览器

        //     document.body.scrollTop = this.pageScrollYoffset;

        //     window.scroll(0, this.pageScrollYoffset);

        // },

    },
    mounted() {
        this.tohome();

        this.fwindow = document.querySelector("#float-window");
        this.fwindow.addEventListener("mousedown", this.movewindowpt);
        document.addEventListener("mouseup", this.movewindowfl);

        // this.fwindow.addEventListener("touchstart", this.mbmovewindowpt);
        // document.addEventListener("touchend", this.movewindowfl);

        // let fwindow = document.querySelector('#float-window');
        // console.log(this.canmove)
        // this.canmove = false

        this.fwindow.addEventListener('touchstart', this.mobilemove, {
            passive: false
        })

        // this.se2.h = window.screen.height;
        // // console.log()
        // this.se2.w = window.screen.width;

        axios.get('/watch/alltimes').then((res) => {

                console.log(res);
                // axios.defaults.headers = {"token": res.data.content.token}

                this.sumwatchtimes = res.data;

            }).catch((err) => {
                console.log(err);

            })

            axios.get('/contact/allcontact').then((res) => {

                console.log(res);
                // axios.defaults.headers = {"token": res.data.content.token}

                this.sumcontacttimes = res.data;

            }).catch((err) => {
                console.log(err);

            })

    },

    methods: {
        changecondition() {
            this.fwindow.style.transition = "all 0.5s"
             var div = document.getElementById('ft-wd-ct');
            if (this.windowbigsize == true) {
                // fwindow.style.transform = "all 0.5s"
                this.fwindow.setAttribute("class", "small-float-window");
                div.style.display = "none";
                // this.fwindow.
            } else {
                // fwindow.style.transform = "all 0.5s"
                this.fwindow.setAttribute("class", "big-float-window");
                setTimeout(function(){
                    var div = document.getElementById('ft-wd-ct');
                    div.style.display = "";},500)

            }
            setTimeout(()=>{var that = this; that.fwindow.style.transition = "all 0.05s"},600)
            this.windowbigsize = !this.windowbigsize

        },

        mobilemove(event) {
            // let fwindow = document.querySelector('#float-window');
            // var time = new Date;
            // this.touchtime = time.getTime();
            console.log(this.windowbigsize);

            event.preventDefault(); //阻止默认行为                 
            event.stopPropagation(); //阻止冒泡  
            var that = this
            var fwindow = this.fwindow

            const click = setTimeout(function () {
                fwindow.style.transition = "all 0.5s"
                var div = document.getElementById('ft-wd-ct');
                if (this.windowbigsize == true) {
                    // fwindow.style.transform = "all 0.5s"
                    fwindow.setAttribute("class", "small-float-window");
                    // var div = document.getElementById('ft-wd-ct');
                    // console.log(div)
                    div.style.display = "none";
                } else {
                    // fwindow.style.transform = "all 0.5s"
                    fwindow.setAttribute("class", "big-float-window");
                    div.style.display = "";

                }
                this.windowbigsize = !this.windowbigsize;
            }, 500)

            click;

            that.canmove = true

            let disX = event.touches[0].clientX - fwindow.offsetLeft
            let disY = event.touches[0].clientY - fwindow.offsetTop

            function fnMove(event) {
                clearTimeout(click);
                fwindow.style.transition = "none"

                var x = event.touches[0].clientX - disX;
                var y = event.touches[0].clientY - disY;

                if (x >= 0 && x <= (window.screen.width - fwindow.clientWidth)) {
                    fwindow.style.left = x + 'px'

                } else if (x < 0) {
                    fwindow.style.left = 0 + "px";
                } else if (x > (window.screen.width - fwindow.clientWidth)) {
                    fwindow.style.left = window.screen.width - fwindow.clientWidth + 'px'

                }

                if (y >= 0 && y <= (document.body.clientHeight - fwindow.clientHeight)) {
                    fwindow.style.top = y + 'px'

                } else if (y < 0) {
                    fwindow.style.top = 0 + "px";
                } else if (y > (document.body.clientHeight - fwindow.clientWidth)) {
                    fwindow.style.top = document.body.clientHeight - fwindow.clientHeight + 'px'

                }

                // fwindow.style.left = event.touches[0].clientX - disX + 'px'
                // fwindow.style.top = event.touches[0].clientY - disY + 'px'
            }

            function fnEnd(event) {
                //     var time = new Date;
                //     var endtime = time.getTime();
                //     console.log(endtime)
                //     console.log(endtime - this.touchtime)
                //     if(time.getTime() - this.touchtime < 1000){
                //         fwindow.style.height = '50px';
                // fwindow.style.width = '50px';
                //     }

                event.preventDefault = true; //阻止默认行为                 
                event.cancelBubble = true; //阻止冒泡  

                that.canmove = false

                fwindow.removeEventListener('touchmove', fnMove, {
                    passive: false
                })
                fwindow.removeEventListener('touchend', fnEnd, {
                    passive: false
                })
            }

            fwindow.addEventListener('touchmove', fnMove, {
                passive: false
            })
            fwindow.addEventListener('touchend', fnEnd, {
                passive: false
            })
        },
        // stopmove(event) {
        //     event.preventDefault()
        // },
        // mbmovewindowpt(e) {

        //     this.x = e.offsetX;
        //     this.y = e.offsetY;

        //     console.log(e.touches[0].offsetX)
        //     console.log(e)

        //     console.log(e.touches[0])

        //     document.addEventListener("touchmove", this.movewindow)

        //     //    document.addEventListener("mousemove",this.movewindow);

        // },

        movewindowpt(e) {

            this.x = e.offsetX;
            this.y = e.offsetY;

            console.log(e)

            document.addEventListener("mousemove", this.movewindow)
            // document.addEventListener("touchmove", this.movewindow)

            //    document.addEventListener("mousemove",this.movewindow);

        },
        movewindow(e) {
            if (!this.moveevent) {
                return false
            }
            this.moveevent = false;

            this.timeout = setTimeout(() => {
                var x = e.pageX - this.x
                var y = e.pageY - this.y
                if (x >= 0 && x <= (document.body.clientWidth - this.fwindow.clientWidth)) {
                    this.fwindow.style.left = x + "px";

                } else if (x < 0) {
                    this.fwindow.style.left = 0 + "px";
                } else if (x > (document.body.clientWidth - this.fwindow.clientWidth)) {
                    this.fwindow.style.left = document.body.clientWidth - this.fwindow.clientWidth + "px";
                }

                if (y >= 0 && y <= (document.body.clientHeight - this.fwindow.clientHeight)) {
                    this.fwindow.style.top = y + "px";

                } else if (y < 0) {
                    this.fwindow.style.top = 0 + "px";
                } else if (y > (document.body.clientHeight - this.fwindow.clientWidth)) {
                    this.fwindow.style.top = document.body.clientHeight - this.fwindow.clientHeight + "px";
                }

                // this.fwindow.style.left = x + "px";
                // this.fwindow.style.top = y + "px";

                this.moveevent = true;
            }, 50)

        },
        movewindowfl() {
            this.moveevent = true;
            clearTimeout(this.timeout);
            document.removeEventListener("mousemove", this.movewindow);
            // document.removeEventListener("touchmove", this.movewindow);

        },

        login() {
            // http://localhost:8088/user/login?password=lfs1234&loginName=lfs
            axios.get('/user/login', {
                params: {
                    loginName: this.form.name,
                    password: this.form.password
                }
            }).then((res) => {

                console.log(res);
                // axios.defaults.headers = {"token": res.data.content.token}

                sessionStorage.setItem('token', res.data.content.token)

            }).catch((err) => {
                console.log(err);

            })
        },

        find() {
            // http://47.97.222.87:8088/user/findall
            console.log(axios.defaults.headers);

            axios.get('/user/findall').then(function (res) {

                    console.log(res);

                })
                .catch(function (error) {
                    console.log(error);
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


#float-window {

    position: fixed;
    top: 0px;
    left: 0;

    z-index: 999;
    font-size: 18px;
    font-weight: 900;


    /* transition: all .5s; */

}

.big-float-window {
    height: 200px;
    width: 200px;
    background-color: #2196f3;
    border-radius: 25px;
}
.big-float-window::before {
    content: '-';
    text-align: left;
    font-size: 30px;
    font-weight: 900;
    line-height: 50px;
    
}

.small-float-window {
    height: 50px;
    width: 50px;
    background-color: #2196f3;
    border-radius: 25px;
    
}
.small-float-window::after {
    content: '+';
    text-align: left;
    font-size: 30px;
    font-weight: 900;
    line-height: 50px;
    
}

/* #float-window div {
    position: absolute;
    height: 100%;
    width: 100%;
    left: 0px;
    top: 0px;
    background-color: #797979;

} */

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
