<template>
<div class="bg">
    <el-container>
        <el-aside >Aside</el-aside>
        <el-container>
            <el-header>Header</el-header>
            <el-main>Main</el-main>
            <el-footer>Footer</el-footer>
        </el-container>
    </el-container>
</div>
</template>

<style>
@import url('views/css/nomalize.css');
.bg{
  background-color: #111111;
}
.el-header,
.el-footer {
    margin: 30px 30px 30px 0px;
    background-color: #222222;
    color: #ffffff;
    text-align: center;
    line-height: 60px;
}

.el-aside {
    margin: 30px;
    background-color: #171717;
    color: #ffffff;
    text-align: center;
    line-height: 200px;
}

.el-main {
  margin-right: 30px;
    background-color: #222222;
    color: #ffffff;
    text-align: center;
    line-height: 160px;
}

body>.el-container {
    margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
    line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
    line-height: 320px;
}
</style>
<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}
</style>
