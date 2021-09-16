<!--
 * @Author: your name
 * @Date: 2021-09-03 11:36:32
 * @LastEditTime: 2021-09-16 17:45:59
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/views/index/Protifio.vue
-->
<template>
<div>
    <div class="portfolio" id="sss">
        <div class="portfolio-header">
            <div class="portfolio-title">
                <span class="portfolio-img"></span>
                <span class="portfolio-portfolio"> My Portfolio</span>
            </div>
            <div class="portfolio-title-content">I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li. </div>
        </div>
        <div class="portfolio-content">
            <div class="pt-menu">
                <ul id="menulists">
                    <li v-for="(ct,i) in menulist" key="ct.uid" @click="selectcategory(ct,i)">{{ct}}</li>
                </ul>
            </div>
            <div class="pt-contents">
                <div class="pt-content" v-for="(img,i) in contentlist" key="i" @click="clicktolink(img.link)">
                    <div class="mask" style="font-size:40px">{{img.id}}</div>
                </div>
            </div>
            <!-- <div class="pt-button">Load More</div> -->
        </div>

        <el-popover placement="bottom" :width="360" trigger="click">

            <el-form :model="form">
                <el-form-item label="Id">
                    <el-input v-model="form.id" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Category">
                    <el-radio-group v-model="form.category">

                        <el-radio label="App">App</el-radio>
                        <el-radio label="Web">Web</el-radio>
                        <el-radio label="Software">Software</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="link">
                    <el-input v-model="form.link" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="image">
                    <input type="file" @change="savefile" autocomplete="off" style="color:black">
                </el-form-item>

            </el-form>
            <div class="demo-drawer__footer">

                <el-button type="primary" @click="comfirmInsert()">Comfirm</el-button>

            </div>
            <template #reference>
                <el-button type="primary" @click="insertPortfolio()">Insert</el-button>

            </template>

        </el-popover>
        <el-popover placement="bottom" :width="360" trigger="click">

            <el-form :model="form">
                <el-form-item label="Id">
                    <el-input v-model="form.id" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div class="demo-drawer__footer">

                <el-button type="primary" @click="comfirmDelete()">Delete</el-button>

            </div>
            <template #reference>
                <el-button type="primary">Delete</el-button>

            </template>

        </el-popover>

        <el-popover placement="bottom" :width="360" trigger="click">

            <el-form :model="form">
                <el-form-item label="Id">
                    <el-input v-model="form.id" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Category">
                    <el-radio-group v-model="form.category">

                        <el-radio label="App">App</el-radio>
                        <el-radio label="Web">Web</el-radio>
                        <el-radio label="Software">Software</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="link">
                    <el-input v-model="form.link" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="image">
                    <input type="file" @change="savefile" autocomplete="off" style="color:black">
                </el-form-item>

            </el-form>
            <div class="demo-drawer__footer">

                <el-button type="primary" @click="comfirmEdit()">Comfirm</el-button>

            </div>
            <template #reference>
                <el-button type="primary">Edit</el-button>

            </template>

        </el-popover>

    </div>
</div>
</template>

<script>
import axios from 'axios'
import {
    ElMessage
} from 'element-plus'

export default {
    data() {
        return {
            file: null,

            form: {
                id: 0,
                category: "Web",
                link: "http://47.97.222.87",
                linkimg: "/file/download?fileName=donnyl.png"
            },
            menulist: ["All", "App", "Web", "Software"],
            contentlist: [

                {
                    category: "web",
                    link: "http://47.97.222.87",
                    linkimg: "/file/download?fileName=donnyl.png"
                },
                {
                    category: "web",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "web",
                    link: "",
                    linkimg: ""
                }, {
                    category: "web",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "web",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "web",
                    link: "",
                    linkimg: ""
                }, {
                    category: "web",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "web",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "web",
                    link: "",
                    linkimg: ""
                }
            ],
            contents: [

                {
                    category: "Web",
                    link: "http://47.97.222.87",
                    linkimg: "/file/download?fileName=donnyl.png"
                },
                {
                    category: "Web",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "App",
                    link: "",
                    linkimg: ""
                }, {
                    category: "App",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "Web",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "Software",
                    link: "",
                    linkimg: ""
                }, {
                    category: "Software",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "Software",
                    link: "",
                    linkimg: ""
                },
                {
                    category: "Software",
                    link: "",
                    linkimg: ""
                }
            ],
        }
    },

    beforeRouteLeave(to, from, next) {
        window.removeEventListener("resize", this.computeh)
        next();
    },

    mounted() {
        this.getPortfolio();
        window.addEventListener("resize", this.computeh);
        this.computeh();
        setTimeout(this.flashbacground(), 1000);
        this.selectmenu(0);

    },
    watch: {
        contentlist(newValue, oldValue) {
            this.$nextTick(function () {
                this.computeh();
                this.flashbacground()
            })

        }
    },
    methods: {
        savefile(event) {
            var that = this
            that.file = event.target.files[0];
            console.log(that.file)
            let formData = new FormData();

            //          formData.append('file', files);              //file  是你接口参数名

        },
        insertPortfolio() {
            this.form = {
                category: "web",
                link: "http://47.97.222.87",
                linkimg: "/file/download?fileName=donnyl.png"
            }
        },
        comfirmInsert() {

            let formData = new FormData();

            formData.append('file', this.file);
            formData.append('category', this.form.category);
            formData.append('link', this.form.link);

            axios.post(
                '/portfolio/insert', formData

            ).then((res) => {
                console.log(res);
                ElMessage.success({
                    message: 'success',
                    type: 'success',
                })
            }).catch((err) => {
                console.log(err);
                ElMessage.error('error')
            });
        },
        comfirmEdit() {
            let formData = new FormData();
            formData.append('id', this.form.id);
            formData.append('file', this.file);
            formData.append('category', this.form.category);
            formData.append('link', this.form.link);

            axios.post(
                '/portfolio/edit', formData

            ).then((res) => {
                console.log(res);
                ElMessage.success({
                    message: 'success',
                    type: 'success',
                })
            }).catch((err) => {
                console.log(err);
                ElMessage.error('error')
            });
        },

        comfirmDelete() {
            axios.get(
                '/portfolio/delete', {
                    params: {
                        id: this.form.id
                    }
                }

            ).then((res) => {
                console.log(res);
                ElMessage.success({
                    message: 'success',
                    type: 'success',
                })
            }).catch((err) => {
                console.log(err);
                ElMessage.error('error')
            });
        },
        getPortfolio() {
            axios.get(
                '/portfolio/all',

            ).then((res) => {
                this.contents = res.data.content;
                this.contentlist = this.contents;
                console.log(res);
            }).catch((err) => {
                console.log(err);
                ElMessage.error('error')
            });
        },
        selectcategory(cg, index) {
            this.selectmenu(index)
            if (cg == "All") {
                this.computeh();
                return this.contentlist = this.contents;
            }
            var list = [];
            for (let index = 0; index < this.contents.length; index++) {
                if (this.contents[index].category == cg) {
                    list.push(this.contents[index]);

                }

            }
            this.contentlist = [];
            this.contentlist = list;

            // this.computeh();
            // setTimeout(this.flashbacground(), 1000)

        },
        selectmenu(index) {
            var menu = document.querySelector("#menulists").querySelectorAll("li");
            // menu.querySelectorAll("li");
            for (let index = 0; index < menu.length; index++) {
                menu[index].style.backgroundColor = "";
                menu[index].style.transform = "";

            }
            menu[index].style.backgroundColor = "#2196f3";
            menu[index].style.transform = "scale(1.2)"

        },

        clicktolink(link) {
            window.open(link);

        },
        flashbacground() {
            var divcontent = document.querySelectorAll(".pt-content");
            for (let index = 0; index < divcontent.length; index++) {
                var ft = divcontent[index].querySelector("div");
                ft.parentElement.style.backgroundImage = "";
                if (this.contentlist[index].linkimg != "") {

                    ft.parentElement.style.backgroundImage = "url(" + axios.defaults.baseURL + this.contentlist[index].linkimg + ")";
                    ft.parentElement.style.backgroundSize = "100% 100%";

                }

            }

        },

        computeh() {
            var divcontent = document.querySelector(".pt-contents");
            var divimg = divcontent.querySelectorAll("div");
            console.log(divimg);
            if (divimg.length == 0) {
                return
            }
            var w = divimg[0].clientWidth;
            for (let index = 0; index < divimg.length; index++) {
                divimg[index].style.height = w * 3 / 4 + "px";

            }
        }
    },

}
</script>

<style>
@import url("../css/portfolio.css");
</style>
