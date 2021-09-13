<!--
 * @Author: your name
 * @Date: 2021-09-03 10:52:07
 * @LastEditTime: 2021-09-13 12:05:32
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/views/index/About.vue
-->
<template>
<div>
    <div class="about">
        <div class="about-header">
            <div class="about-title">
                <span class="about-img"></span>
                <span class="about-aboutme">About Me</span>
            </div>
            <div class="about-title-content">I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li. </div>
        </div>
        <div class="about-content">
            <div class="about-personal">PERSONAL&nbspDETAILS</div>
            <div class="about-personal-details" v-for="(item,i) in detailslist" key="i">
                <span class="about-details-hd" c>{{item.title}}</span>
                :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <span class="about-details-ct">{{item.content}}</span>

            </div>
        </div>

    </div>
</div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            detailslist: [{
                    title: 'Fullname',
                    content: 'Fangsai Li'
                },
                {
                    title: 'Nickname',
                    content: 'Donny'
                },
                {
                    title: 'Father\'s Name',
                    content: 'Wenbing Li'
                },
                {
                    title: 'Address',
                    content: 'China Wubei Ezhou Yanglanguojikangcheng 31'
                },
                {
                    title: 'Zip Code',
                    content: '436000'
                },
                {
                    title: 'Phone',
                    content: '+86 19512102264'
                },
                {
                    title: 'Email',
                    content: '1340710624@qq.com , k1814426@kcl.ac.uk'
                },
                {
                    title: 'Website',
                    content: 'https://donnyl.top'
                },

            ]
        }
    },
    mounted() {
       this.getContent()
    },
    methods: {
        getContent() {
            axios.get(
                '/about/all',

            ).then((res) => {
                this.detailslist = res.data.content;
                console.log(res);
            }).catch((err) => {
                console.log(res);
            });
        }
    },
}
</script>

<style>
@import url("../css/about.css");
</style>
