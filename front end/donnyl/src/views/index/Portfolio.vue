<!--
 * @Author: your name
 * @Date: 2021-09-03 11:36:32
 * @LastEditTime: 2021-09-08 18:11:53
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
                    <div class="mask"></div>
                </div>
            </div>
            <!-- <div class="pt-button">Load More</div> -->
        </div>
    </div>
</div>
</template>

<script>
export default {
    data() {
        return {
            menulist: ["All", "App", "Web", "Software"],
            contentlist: [

                {
                    category: "web",
                    link: "http://47.97.222.87",
                    linkimg: "http://47.97.222.87:8088/file/download?fileName=donnyl.png"
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
                    linkimg: "http://47.97.222.87:8088/file/download?fileName=donnyl.png"
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
    mounted() {
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
        selectcategory(cg,index) {
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
        selectmenu(index){
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

                    ft.parentElement.style.backgroundImage = "url(" + this.contentlist[index].linkimg + ")";
                    ft.parentElement.style.backgroundSize = "100% 100%";

                }

            }

        },

        computeh() {
            var divcontent = document.querySelector(".pt-contents");
            var divimg = divcontent.querySelectorAll("div");
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
