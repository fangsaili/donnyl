<!--
 * @Author: your name
 * @Date: 2021-09-03 11:36:01
 * @LastEditTime: 2021-09-08 11:38:06
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/views/index/Eduction.vue
-->
<template>
<div>
    <div class="education">
        <div class="education-header">
            <div class="education-title">
                <span class="education-img"></span>
                <span class="education-education">Education</span>
            </div>
            <div class="education-title-content">I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li. </div>
        </div>
        <div class="education-content">
            <div class="education-contents" v-for="(item,i) in contents" key="i">
                <div class="ed-ct-hd" @click="clickopen(i)">
                    <span></span>
                    <span>{{item.title}}</span>
                    <span>&nbsp-&nbsp{{item.position}}</span>
                    <span  v-show="contents[i].show"></span>
                    <span  v-show="!contents[i].show"></span>
                </div>
                <div class="ed-ct-ct">
                    {{item.content}}
                </div>

            </div>
        </div>

    </div>
</div>
</template>

<script>
export default {
    data() {
        return {
            contents: [{
                show: false,
                color: "color:blue",
                title: "HIGH SCHOOL DEGREE",
                position: "WUHAN,2017-2019",
                content: "I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.",
            }, {
                show: false,
                color: "color:blue",
                title: "HIGH SCHOOL DEGREE",
                position: "WUHAN,2017-2019",
                content: "I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.",
            }]
        }
    },
    mounted() {
        this.selectcolor()

    },
    methods: {
        selectcolor() {
            var ct = document.querySelectorAll(".ed-ct-hd");
            for (let index = 0; index < ct.length; index++) {
                var span = ct[index].querySelectorAll("span");
                var numb = Math.floor(Math.random() * (5) + 1);
                span[0].className = "span-svg" + numb;
                span[3].className = "span4-svg" + numb;
                span[4].className = "span5-svg" + numb;

            }

        },
        clickopen(index) {
            var ct = document.querySelectorAll(".ed-ct-ct");
            if (!this.contents[index].show) {
                ct[index].style = "max-height:1000px;padding: 30px 40px;"

                console.log(1000)

            } else {

                ct[index].style = "max-height:0;padding: 0"
                console.log(0)

            }
            this.contents[index].show = !this.contents[index].show;

        }
    },
}
</script>

<style>
@import url("../css/education.css");
</style>
