<!--
 * @Author: your name
 * @Date: 2021-09-03 11:37:21
 * @LastEditTime: 2021-09-13 12:00:13
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
                <div class="experience-work-ds" v-for="(work,i) in works" key="i">
                    <div class="work-title">
                        <div></div>{{work.title}}
                    </div>
                    <div class="work-date">{{work.date}}</div>
                    <div class="work-description">{{work.description}}</div>
                    <div class="work-link" @click="worklink(i)">{{work.link}}</div>
                </div>
            </div>
            <div class="experience-award">
                <div class="award-title">
                    <div></div>{{awards.length}} AWARD WINS
                </div>
                <div class="awards-content" v-for="(award,i) in awards" key="i">
                    <div>
                        <span v-if="i<9">0{{i + 1}}</span><span v-else>{{i + 1}}</span> {{award.title}}</div>
                    <div>{{award.description}}</div>
                </div>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
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
                },{
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
        getWorks(){
            axios.get(
                '/experience/allwork',

            ).then((res) => {
                this.works = res.data.content;
                console.log(res);
            }).catch((err) => {
                console.log(res);
            });

        },
        getAwards(){
            axios.get(
                '/experience/allaward',

            ).then((res) => {
                this.awards = res.data.content;
                console.log(res);
            }).catch((err) => {
                console.log(res);
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
