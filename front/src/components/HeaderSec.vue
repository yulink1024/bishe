<template>
    <ul class="app-header-nav">
        <li><router-link to="/Meishi">美食</router-link></li>
        <li><router-link to="/Canchu">餐厨</router-link></li>
        <li><router-link to="/Yishu">艺术</router-link></li>
        <li><router-link to="/Dianqi">电器</router-link></li>
        <li><router-link to="/Jujia">居家</router-link></li>
        <li><router-link to="/Xihu">洗护</router-link></li>
        <li><router-link to="/Fuzhuang">服装</router-link></li>
    </ul>
    <router-view></router-view>
</template>

<script>
export default {
    data(){

        return{
            is_Show:"美食"
        }
    }
}
</script>

<style lang="less" scoped>
.app-header-nav{

    li{
        position: relative;
        float: left;
        padding: 0 10px;
        font-size: 15px;
        font-weight: bold;

        a:hover{
            color: @xtxColor;
            border-bottom: 2px solid @xtxColor;
        }
        a{
            padding-bottom:2px;
        }
        //选中高亮
        .router-link-active{
            color: @xtxColor;
            border-bottom: 2px solid @xtxColor;
        }

    }
}
</style>