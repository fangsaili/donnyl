<!--
 * @Author: your name
 * @Date: 2021-09-03 10:52:16
 * @LastEditTime: 2021-09-07 09:42:49
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
                <button class="downloadimg" @click="toportfolio()">
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
        // setInterval(this.changeHeight, 1000)
        this.changeHeight();
        window.addEventListener("resize",this.changeHeight)

    },
    methods: {
        toportfolio(){
            this.$router.push("/index/portifio");
            var lst = document.querySelector('.menulist');
            var lis = lst.querySelectorAll('li');
            
            for (var i = 0;i<11;i++) {
                lis[i].style.backgroundColor = '';
            }
            lis[4].style.backgroundColor = '#2196f3';
            lis[4].style.transform = 'scale(1.2)';
        },
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
