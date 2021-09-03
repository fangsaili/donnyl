<!--
 * @Author: your name
 * @Date: 2021-09-03 10:52:16
 * @LastEditTime: 2021-09-03 17:33:12
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/views/index/Home.vue
-->
<template>
<div class="home" id="home">
    <div class="home-content">
        <div class="home-self">
            <div class="hello">Hello.</div>
            <div class="name">My name is Fangsai</div>
            <div class="im">& I'm absolutely design addicted</div>
            <div class="d-downloadimg">
                <button class="downloadimg">
                    <span class="img">

                    </span>
                    <span class="txt">Portfolio</span>
                </button>
            </div>
        </div>
        <div class="home-self-img">
            <div class="picture">
                 
                <div class="message"></div>
            </div>
        </div>
        <div class="home-slider-point">

        </div>
    </div>
</div>
</template>

<script>
export default {
    name: 'Mehome',

    mounted() {
        setInterval(this.changeHeight, 1000)

    },
    methods: {
        changeHeight() {
            var hg = document.querySelector('.el-main');
            document.getElementById('home').style.height = hg.clientHeight - 40 + 'px';

        },
    },
}
</script>

<style>
@import url('../css/home.css');
</style>
