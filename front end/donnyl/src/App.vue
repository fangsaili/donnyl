<!--
 * @Author: your name
 * @Date: 2021-09-01 16:40:24
 * @LastEditTime: 2021-09-02 18:25:50
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/App.vue
-->
<template>
<div class="bg">
    <el-container>
        <!-- lift area Aside cv -->
        <el-aside>
            <div class="details">
                <div class="toutou"></div>
                <div class="d-name">
                    <div class="l-name">Fangsai Li</div>
                    <div class="sm-name">
                        <span>UX/UI Designer </span>
                        <span>in Dewas</span>
                    </div>
                </div>
                <div class="d-links">
                    <ul>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
                <div class="d-self">
                    <div class="d-title">What’s in My Mind</div>
                    <div class="d-content">
                        We can develop and design anything beyond your ima gination. About
                        our work, we don’t say anything bec ause our work speaks. For
                        more, you can ask our clie nts and they will tell you how much
                        satisfied they are with our services. So, what are you waiting
                        for?
                    </div>
                </div>
                <div class="d-downloadcv">
                    <button class="downloadcv">
                        <span class="down">
                            
                        </span>
                        <span>Download CV</span>
                    </button>
                </div>
            </div>
        </el-aside>

        <!-- right area Menu and Main-->
        <el-container class="right-area">
            <el-header>Header</el-header>
            <el-main>
                <div v-for="(item, i) in mainlist" key="item">
                    MAIN{{ i }}
                </div>
            </el-main>
            <el-footer>Footer</el-footer>
        </el-container>
    </el-container>
</div>
</template>

<script>
import {
    Download
} from '@element-plus/icons'
export default {
    components: {
        Download,
    },
    data() {
        return {
            mainlist: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        };
    },
};
</script>

<style>
@import url("assets/css/leftarea.css");
@import url("views/css/nomalize.css");
@import url("assets/font/merienda/Merienda.css");

.right-area {
    height: 100vh;
    overflow: scroll;
}

.bg {
    background-color: #111111;
}

.el-header,
.el-footer {
    height: 100px;
    margin: 2vw 2vw 2vw 0px;
    background-color: #222222;
    color: #ffffff;
    text-align: center;
    line-height: 60px;
}

.el-aside {
    width: 20%;
    margin: 2vw;
    background-color: #222222;

    text-align: center;
}

.el-main {
    margin-right: 2vw;
    background-color: #222222;
    color: #ffffff;
    text-align: center;
    line-height: 160px;
    font: 900;
    font-size: 20px;
    font-family: "Merienda";
}

html {
    min-width: 800px;
}

#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    min-width: 800px;
}
</style>
