<!--
 * @Author: your name
 * @Date: 2021-09-03 10:52:26
 * @LastEditTime: 2021-09-07 16:02:27
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/views/index/Skills.vue
-->
<template>
<div>
    <div class="skills" id="sss">
        <div class="skills-header">
            <div class="skills-title">
                <span class="skills-img"></span>
                <span class="skills-skills">My Skills</span>
            </div>
            <div class="skills-title-content">I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li. </div>
        </div>
        <div class="professional-skills">
            <div class="skill-head">PROFESSIONAL&nbspSKILLS</div>
            <div class="skill-content" v-for="(item,i) in skillp" key="i">
                <el-progress type="dashboard" :percentage="item.percentage" :color="customColorMethod(item.percentage,i)" :width="prowidth" :stroke-width="8" :indeterminate="true" :duration="3">
                    <template #default="{ percentage }">
                        <div class="percentage-value" :style="item.color">{{ item.percentage }}%</div>
                        <div class="percentage-label">{{item.name}}</div>
                    </template>
                </el-progress>

            </div>
        </div>

    </div>
</div>
</template>

<script>
export default {
    data() {
        return {
            prowidth: 150,
            skillp: [{
                    name: 'Photoshop',
                    percentage: 10,
                    color: 'color:#f56c6c'
                },
                {
                    name: 'HTML5',
                    percentage: 90,
                    color: 'color:#f56c6c'
                },
                {
                    name: 'CSS3',
                    percentage: 60,
                    color: 'color:#f56c6c'
                },
                {
                    name: 'JavaScript',
                    percentage: 60,
                    color: 'color:#f56c6c'
                },
                {
                    name: 'Java',
                    percentage: 80,
                    color: 'color:#f56c6c'
                },
                {
                    name: 'C++',
                    percentage: 40,
                    color: 'color:#f56c6c'
                }

            ],

        }
    },
    mounted() {
        this.changeWidth();
        window.addEventListener("resize", this.changeWidth);

        for (let index = 0; index < this.skillp.length; index++) {
            this.movechange(this.skillp[index].percentage, index)

        }

    },

    methods: {
        movechange(percentage, index) {
            var that = this;
            var per = 0;
            var change = setInterval(function () {
                if (per > percentage) {

                    clearInterval(change);

                } else {
                    that.skillp[index].percentage = per;
                    per++;
                }

            }, 20)

        },

        customColorMethod(percentage, index) {
            if (percentage < 20) {
                this.skillp[index].color = 'color:' + '#f56c6c';
                return '#f56c6c'
            } else if (percentage < 40) {
                this.skillp[index].color = 'color:' + '#e6a23c';

                return '#e6a23c'
            } else if (percentage < 60) {
                this.skillp[index].color = 'color:' + '#5cb87a';

                return '#5cb87a'
            } else if (percentage < 80) {
                this.skillp[index].color = 'color:' + '#1989fa';
                return '#1989fa'
            } else {
                this.skillp[index].color = 'color:' + '#6f7ad3';

                return '#6f7ad3'
            }
        },
        changeWidth() {
            var wg = document.querySelector('.el-main');
            if (wg.clientWidth < 700) {
                this.prowidth = 80;
            } else {
                this.prowidth = 150;
            }
        }
    },

}
</script>

<style>
@import url("../css/skills.css");
</style>
