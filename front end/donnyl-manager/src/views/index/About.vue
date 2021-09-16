<!--
 * @Author: your name
 * @Date: 2021-09-03 10:52:07
 * @LastEditTime: 2021-09-16 17:48:46
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
                <el-popover placement="left" :width="360" trigger="click">

                    <el-form :model="form">
                        <el-form-item label="Id">
                            <el-input v-model="form.id" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="Title">
                            <el-input v-model="form.title" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="Content">
                            <el-input v-model="form.content" autocomplete="off"></el-input>
                        </el-form-item>

                    </el-form>
                    <div class="demo-drawer__footer">

                        <el-button type="primary" @click="comfirmChange()">Comfirm</el-button>

                    </div>
                    <template #reference>
                        <span class="about-details-change" @click="editcontent(i)">{{item.id}}</span>

                    </template>

                </el-popover>

            </div>
        </div>

    </div>

</div>
</template>

<script>
import axios from 'axios';
import {
    ElMessage
} from 'element-plus'
export default {
    data() {
        return {
            // showchange: false,
            form: {
                id: 1,
                title: '',
                content: '',
            },
            detailslist: [

            ]
        }
    },
    mounted() {
        this.getContent()
    },
    methods: {
        editcontent(index) {
            this.form = this.detailslist[index]
        },
        comfirmChange(){
            axios.get(
                '/about/edit',
                {params:{
                    id:this.form.id,
                    title:this.form.title,
                    content:this.form.content,
                }}

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
        getContent() {
            axios.get(
                '/about/all',

            ).then((res) => {
                this.detailslist = res.data.content;
                console.log(res);
            }).catch((err) => {
                console.log(res);
                ElMessage.error('error')

            });
        }
    },
}
</script>

<style>
@import url("../css/about.css");
</style>
