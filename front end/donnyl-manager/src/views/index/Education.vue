<!--
 * @Author: your name
 * @Date: 2021-09-03 11:36:01
 * @LastEditTime: 2021-09-16 17:43:36
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
                    <el-popover placement="bottom" :width="360" trigger="click">

                        <el-form :model="form">
                            <el-form-item label="Id">
                                <el-input v-model="form.id" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="Name">
                                <el-input v-model="form.title" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="Title">
                                <el-input v-model="form.position" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="Content">
                                <el-input type="textarea" v-model="form.content" autocomplete="off"></el-input>
                            </el-form-item>

                        </el-form>
                        <div class="demo-drawer__footer">

                            <el-button type="primary" @click="comfirmEdit()">Comfirm</el-button>
                            <el-button type="primary" @click="deleteSkill()">Delete</el-button>

                        </div>
                        <template #reference>
                            <span @click="edit(i)">{{item.title}}</span>

                        </template>

                    </el-popover>

                    <span>&nbsp-&nbsp{{item.position}}</span>
                    <span v-show="contents[i].show"></span>
                    <span v-show="!contents[i].show"></span>
                </div>
                <div class="ed-ct-ct">
                    {{item.content}}
                </div>

            </div>
        </div>
        <el-popover placement="bottom" :width="360" trigger="click">

            <el-form :model="form">
                <el-form-item label="Id">
                    <el-input v-model="form.id" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Name">
                    <el-input v-model="form.title" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Title">
                    <el-input v-model="form.position" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Content">
                    <el-input type="textarea" v-model="form.content" autocomplete="off"></el-input>
                </el-form-item>

            </el-form>
            <div class="demo-drawer__footer">

                <el-button type="primary" @click="comfirmInsert()">Comfirm</el-button>

            </div>
            <template #reference>
                <el-button type="primary" @click="insertEducation()">Insert</el-button>

            </template>

        </el-popover>

    </div>
</div>
</template>

<script>
import axios from 'axios'
import { ElMessage } from 'element-plus'

export default {
    data() {
        return {
            form: {
                show: 0,
                id: 0,
                color: 'color:blue',
                title: 'HIGH SCHOOL DEGREE',
                position: 'WUHAN , 2017-2019',
                content: "I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.",
            },
            contents: [{
                show: 0,
                color: "color:blue",
                title: "HIGH SCHOOL DEGREE",
                position: "WUHAN,2017-2019",
                content: "I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.",
            }, {
                show: 0,
                color: "color:blue",
                title: "HIGH SCHOOL DEGREE",
                position: "WUHAN,2017-2019",
                content: "I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.",
            }]
        }
    },
    mounted() {
        this.selectcolor()
        this.getEducation();

    },
    methods: {
        insertEducation() {
            this.form = {
                show: 0,
                id: 0,
                color: 'color:blue',
                title: 'HIGH SCHOOL DEGREE',
                position: 'WUHAN , 2017-2019',
                content: "I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.",
            }
        },
        comfirmInsert() {
            axios.get(
                '/education/insert', {
                    params: {

                        title: this.form.title,
                        position: this.form.position,
                        content: this.form.content,

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
        edit(index) {
            this.form = this.contents[index]

        },
        comfirmEdit() {
            axios.get(
                '/education/edit', {
                    params: {
                        id: this.form.id,
                        title: this.form.title,
                        position: this.form.position,
                        content: this.form.content,

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
        deleteSkill() {
            axios.get(
                '/education/delete', {
                    params: {

                        id: this.form.id,

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
        getEducation() {
            axios.get(
                '/education/all',

            ).then((res) => {
                this.contents = res.data.content;
                console.log(res);
            }).catch((err) => {
                console.log(err);
                ElMessage.error('error')
            });

        },
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

            } else {

                ct[index].style = "max-height:0;padding: 0"

            }
            this.contents[index].show = !this.contents[index].show;

        }
    },
}
</script>

<style>
@import url("../css/education.css");
</style>
