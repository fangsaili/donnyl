<!--
 * @Author: your name
 * @Date: 2021-09-03 11:37:21
 * @LastEditTime: 2021-09-16 17:45:35
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/views/index/Experience.vue
-->
<template>
<div>
    <div class="experience" id="sss">
        <div class="experience-header">
            <div class="experience-title">
                <span class="experience-img"></span>
                <span class="experience-experience"> Work Experience</span>
            </div>
            <div class="experience-title-content">I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li. </div>
        </div>
        <div class="experience-content">
            <div class="experience-work">
                <el-popover placement="bottom" :width="360" trigger="click">

                    <el-form :model="form">

                        <el-form-item label="Title">
                            <el-input v-model="form.title" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="Date">
                            <el-input v-model="form.date" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="Dscription">
                            <el-input type="textarea" v-model="form.description" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="Link">
                            <el-input v-model="form.link" autocomplete="off"></el-input>
                        </el-form-item>

                    </el-form>
                    <div class="demo-drawer__footer">

                        <el-button type="primary" @click="comfirmAddWork()">Comfirm</el-button>

                    </div>
                    <template #reference>
                        <el-button type="success">Add Work</el-button>

                    </template>

                </el-popover>
                <div class="experience-work-ds" v-for="(work,i) in works" key="i">

                    <div class="work-title">
                        <div></div>{{work.title}}
                    </div>
                    <div class="work-date">{{work.date}}</div>
                    <div class="work-description">{{work.description}}</div>
                    <div class="work-link" @click="worklink(i)">{{work.link}}</div>

                    <el-popover placement="bottom" :width="360" trigger="click">

                        <el-form :model="form">
                            <el-form-item label="Id">
                                <el-input v-model="form.id" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="Title">
                                <el-input v-model="form.title" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="Date">
                                <el-input v-model="form.date" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="Dscription">
                                <el-input type="textarea" v-model="form.description" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="Link">
                                <el-input v-model="form.link" autocomplete="off"></el-input>
                            </el-form-item>

                        </el-form>
                        <div class="demo-drawer__footer">

                            <el-button type="primary" @click="comfirmEditWork()">Comfirm</el-button>
                            <el-button type="danger" @click="deleteWork()">Delete</el-button>

                        </div>
                        <template #reference>
                            <el-button type="primary" @click="editWork(i)">Edit</el-button>

                        </template>

                    </el-popover>
                </div>
            </div>
            <div class="experience-award">
                <el-popover placement="bottom" :width="360" trigger="click">

                    <el-form :model="form">

                        <el-form-item label="Title">
                            <el-input v-model="formaward.title" autocomplete="off"></el-input>
                        </el-form-item>

                        <el-form-item label="Dscription">
                            <el-input type="textarea" v-model="formaward.description" autocomplete="off"></el-input>
                        </el-form-item>

                    </el-form>
                    <div class="demo-drawer__footer">

                        <el-button type="primary" @click="comfirmAddAward()">Comfirm</el-button>

                    </div>
                    <template #reference>
                        <el-button type="success">Add Award</el-button>

                    </template>

                </el-popover>
                <div class="award-title">

                    <div></div>{{awards.length}} AWARD WINS

                </div>
                <div class="awards-content" v-for="(award,i) in awards" key="i">
                    <div>
                        <span v-if="i<9">0{{i + 1}}</span><span v-else>{{i + 1}}</span> {{award.title}}</div>
                    <div>{{award.description}}</div>
                    <el-popover placement="bottom" :width="360" trigger="click">

                        <el-form :model="form">
                            <el-form-item label="Id">
                                <el-input v-model="formaward.id" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="Title">
                                <el-input v-model="formaward.title" autocomplete="off"></el-input>
                            </el-form-item>

                            <el-form-item label="Dscription">
                                <el-input type="textarea" v-model="formaward.description" autocomplete="off"></el-input>
                            </el-form-item>

                        </el-form>
                        <div class="demo-drawer__footer">

                            <el-button type="primary" @click="comfirmEditAward()">Comfirm</el-button>
                            <el-button type="danger" @click="deleteAward()">Delete</el-button>

                        </div>
                        <template #reference>
                            <el-button type="primary" @click="editAward(i)">Edit</el-button>

                        </template>

                    </el-popover>
                </div>

            </div>
        </div>
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
            form: {
                id: 0,
                title: "Web App Stop Variants",
                date: " ",
                description: "I developed an app for the treatment of OBSessive-compulsive disorder for Jenny, professor of psychology in school, and it can run on Web, IOS and Android",
                link: "https://github.com/fangsaili/Ustarios",
            },
            formaward: {
                id: 0,
                title: "PingPang Ball",
                description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."

            },
            works: [{
                title: "Web App Stop Variants",
                date: " ",
                description: "I developed an app for the treatment of OBSessive-compulsive disorder for Jenny, professor of psychology in school, and it can run on Web, IOS and Android",
                link: "https://github.com/fangsaili/Ustarios",
            }, {
                title: "Web App Stop Variants",
                date: "Jan 2021 - Mar 2021",
                description: "I developed an app for the treatment of OBSessive-compulsive disorder for Jenny, professor of psychology in school, and it can run on Web, IOS and Android",
                link: "https://github.com/fangsaili/Ustarios",
            }, {
                title: "Web App Stop Variants",
                date: "Jan 2021 - Mar 2021",
                description: "I developed an app for the treatment of OBSessive-compulsive disorder for Jenny, professor of psychology in school, and it can run on Web, IOS and Android",
                link: "https://github.com/fangsaili/Ustarios",
            }],
            awards: [{
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                }, {
                    title: "PingPang Ball",
                    description: "Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li. Fangsai Li."
                },

            ],
            Colors: [{
                    color: '#f56c6c'
                },
                {
                    color: '#e6a23c'
                },
                {
                    color: '#5cb87a'
                },
                {
                    color: '#1989fa'
                },
                {
                    color: '#6f7ad3',
                },
            ],
        }
    },
    mounted() {
        this.randancolor();
        this.getWorks();
        this.getAwards();
    },
    methods: {
        editWork(i) {
            this.form = this.works[i]
        },
        comfirmEditWork() {
            axios.get(
                '/experience/work/edit', {
                    params: {
                        id: this.form.id,
                        title: this.form.title,
                        date: this.form.date,
                        description: this.form.description,
                        link: this.form.link,

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
        deleteWork() {
            axios.get(
                '/experience/work/delete', {
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
        comfirmAddWork() {
            axios.get(
                '/experience/work/insert', {
                    params: {

                        title: this.form.title,
                        date: this.form.date,
                        description: this.form.description,
                        link: this.form.link,

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

        editAward(i) {
            this.formaward = this.awards[i]
        },
        comfirmEditAward() {
            axios.get(
                '/experience/award/edit', {
                    params: {
                        id: this.formaward.id,
                        title: this.formaward.title,

                        description: this.formaward.description,

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
        deleteAward() {
            axios.get(
                '/experience/award/delete', {
                    params: {
                        id: this.formaward.id,

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
        comfirmAddAward() {
            axios.get(
                '/experience/award/insert', {
                    params: {

                        title: this.formaward.title,

                        description: this.formaward.description,

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
        getWorks() {
            axios.get(
                '/experience/allwork',

            ).then((res) => {
                this.works = res.data.content;
                console.log(res);

            }).catch((err) => {
                console.log(err);
                ElMessage.error('error')

            });

        },
        getAwards() {
            axios.get(
                '/experience/allaward',

            ).then((res) => {
                this.awards = res.data.content;
                console.log(res);
            }).catch((err) => {
                console.log(err);
                ElMessage.error('error')

            });
        },
        randancolor() {
            var works = document.querySelectorAll(".experience-work-ds");
            for (let index = 0; index < works.length; index++) {
                var i = Math.floor(Math.random() * (5));
                var divs = works[index].querySelectorAll("div");
                divs[1].style.filter = "drop-shadow(" + this.Colors[i].color + " 40px 0)";
                divs[2].style.color = this.Colors[i].color;
                divs[4].style.color = this.Colors[i].color;

            }

        },
        worklink(i) {
            window.open(this.works[i].link)
        }
    },

}
</script>

<style>
@import url("../css/experience.css");
</style>
