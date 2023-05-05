<template>
  <div class="my-header w">
    <!-- 上半区域 -->
    <div class="header-top">
        <!-- logo -->
        <h1 class="logo">
            网上商城
        </h1>
        <!-- search -->
        <div class="center">
            <div class="center-search">
                <input type="text" name="" id="" placeholder="请输入您想搜索的商品">
                <button class="search-btn">搜索</button>
            </div>
        </div>
        <!-- 购物车 -->
        <div class="cart">
            <a href="/#/Gouwu">
                <i class="iconfont icon-gouwuche"></i>
                购物车
            </a>
        </div>
    </div>
    <!-- 二级导航 -->
    <HeaderSec />
  </div>
</template>

<script>
import HeaderSec from '@/components/HeaderSec.vue'
export default {
    components:{
        HeaderSec
    }
}
</script>

<style lang="less" scoped>
.my-header{
    height: 120px;
    padding: 25px 0 0 0;
    // background-color: #ccc;

    .header-top{
        display: flex;
        .logo{
            width: 230px;
            height: 60px;
        }

        .center{
            flex: 1;
            .center-search{
                width: 540px;
                height: 35px;
                input{
                    width: 440px;
                    height: 35px;
                    border: 1px solid @xtxColor;
                    border-radius: 20px 0 0 20px;
                    padding-left: 15px;
                    box-sizing: border-box;
                }
                .search-btn{
                    background-color: @xtxColor;
                    float: right;
                    width: 100px;
                    height: 35px;
                    border-radius: 0 20px 20px 0;
                    border: 1px solid @xtxColor;
                    cursor: pointer;
                }
            }
        }

        .cart{
            box-sizing: border-box;
            width: 150px;
            height: 35px;
            line-height: 32px;
            border-radius: 20px;
            border: 1px solid @xtxColor;
            font-size: 16px;
            text-align: center;
            
            a{
                color: @xtxColor;
            }
        }

    }
}
</style>