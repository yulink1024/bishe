<template>
    <div class="goodsinfo_body">
        <el-card class="el-cardcl">
            <div class="left_img">
                <div class="top_img">
                    <img :src=GoodsDetail.imgurl />
                </div>
                <div class="bottom_btn">
                    <el-button type="success" @click="buyItNow()">购买</el-button>
                    <el-button type="success" @click="AddGouwuche()">加入购物车</el-button>
                </div>
            </div>
            <div class="right_content">
                <ul>
                    <li>商品名称：{{GoodsDetail.goodsName}}</li>
                    <li @click="getTotal()">购买数量：<el-input-number size="small" v-model="goodsnum" :min="1" :max="10"></el-input-number></li>
                    <!-- <li v-if="goodsnum==1">商品总价：¥{{GoodsDetail.goodsPrice}}</li> -->
                    <li>商品总价：¥{{ totalPrice }}</li>
                    <li v-if="stores.state.user.userinfo.isonline">配送地址：{{stores.state.user.userinfo.userAddress}}</li>
                    <li v-else>配送地址：</li>
                    <li v-if="stores.state.user.userinfo.isonline">电话：{{stores.state.user.userinfo.userNumber}}</li>
                    <li v-else>电话：</li>
                </ul>
            </div>
        </el-card>

        <el-button type="success" @click="returns()">返回</el-button>
    </div>
</template>

<script>
import axios from 'axios';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import { ElMessage } from 'element-plus';
export default {
    data(){
        const stores=useStore();
        const router=useRouter();
        return{
            GoodsDetail:{},
            stores,
            router,
            goodsnum:1,
            totalPrice:1,
        }
    },
    mounted:function(){
        axios.post('http://localhost:8080/GetDetail',
        {
            id:this.$route.params.id
        }).then((res)=>{
            this.GoodsDetail=res.data;
            this.totalPrice=this.GoodsDetail.goodsPrice;
        }).catch((error)=>{
            console.log(error)
        })
    },
    methods:{
        buyItNow(){
            if(this.stores.state.user.userinfo.isonline){
                axios.post('http://localhost:8080/AddDingdan',{
                uid:this.stores.state.user.userinfo.id,
                gid:this.GoodsDetail.id,
                imgurl:this.GoodsDetail.imgurl,
                goodsName:this.GoodsDetail.goodsName,
                goodsNum:this.goodsnum,
                totalPrice:this.totalPrice,
                userAddress:this.stores.state.user.userinfo.userAddress,
                }).then((res)=>{
                    if(res.data){
                            ElMessage({
                            message: "购买成功",
                            type:'success'
                        }),
                        this.router.push('/')
                    }else{
                        ElMessage({
                            message:"出错了，请重试",
                            type:'error'
                        })
                    }
                }).catch((error)=>{
                    console.log(error)
                })

                axios.post('http://localhost:8080/addGoumai',{
                    uid:this.stores.state.user.userinfo.id,
                    userName:this.stores.state.user.userinfo.userName,
                    userInterest1:this.GoodsDetail.goodstips1,
                    userInterest2:this.GoodsDetail.goodstips2,
                    userInterest3:this.GoodsDetail.goodstips3,
                }).then((res)=>{
                    console.log(res.data)
                }).catch((error)=>{
                    console.log(error)
                })

                axios.post('http://localhost:8080/GetByUid',{
                    uid:this.stores.state.user.userinfo.id,
                }).then((result)=>{
                    this.stores.commit('UserInterest/setuserInterests',result.data);
                }).catch((error)=>{
                    console.log(error)
                })
            }else{
                this.router.push('/login')
            }
        },
        getTotal(){
            this.totalPrice=this.goodsnum * this.GoodsDetail.goodsPrice;
        },
        AddGouwuche(){
            if(this.stores.state.user.userinfo.isonline){
                axios.post('http://localhost:8080/AddGouwuche',{
                uid:this.stores.state.user.userinfo.id,
                goodid:this.GoodsDetail.id,
                imgurl:this.GoodsDetail.imgurl,
                goodsName:this.GoodsDetail.goodsName,
                goodsNum:this.goodsnum,
                totalPrice:this.totalPrice,
                goodstips1:this.GoodsDetail.goodstips1,
                goodstips2:this.GoodsDetail.goodstips2,
                goodstips3:this.GoodsDetail.goodstips3
                }).then((res)=>{
                    if(res.data){
                            ElMessage({
                            message: "加入购物车成功",
                            type:'success'
                        }),
                        this.router.push('/')
                    }else{
                        ElMessage({
                            message:"加入失败，请重试",
                            type:'error'
                        })
                    }
                }).catch((error)=>{
                    console.log(error)
                })

                axios.post('http://localhost:8080/addGouwu',{
                    uid:this.stores.state.user.userinfo.id,
                    userName:this.stores.state.user.userinfo.userName,
                    userInterest1:this.GoodsDetail.goodstips1,
                    userInterest2:this.GoodsDetail.goodstips2,
                    userInterest3:this.GoodsDetail.goodstips3,
                }).then((res)=>{
                    console.log(res.data)
                }).catch((error)=>{
                    console.log(error)
                })

                axios.post('http://localhost:8080/GetByUid',{
                    uid:this.stores.state.user.userinfo.id,
                }).then((result)=>{
                    this.stores.commit('UserInterest/setuserInterests',result.data);
                }).catch((error)=>{
                    console.log(error)
                })
            }else{
                this.router.push('/login')
            }
        },
        returns(){
            this.router.push('/')
        }
    }
}
</script>

<style lang="less" scoped>
.goodsinfo_body{
    width: 100%;
    height: 753px;
    background-image: url("../assets/images/goodsbg.jpg");
    background-size: 100% 100%;

    .el-cardcl{
        width: 700px;
        height: 500px;
        position: absolute;
        top: calc(50% - 250px);
        left: calc(50% - 350px);
        display: flex;

        /deep/.el-card__body{
            padding: 0;
            width: 700px;
            height: 500px;
            display: flex;
        }
        .left_img{
            width: 300px;
            height: 500px;
            display: flex;
            flex-direction: column;
            background-color: red;
            .top_img{
                width: 300px;
                height: 300px;
                padding: 20px;
                background-color: blue;

                img{
                    width: 100%;
                    height: 100%;
                }
            }

            .bottom_btn{
                width: 300px;
                height: 200px;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: aqua;
            }
        }

        .right_content{
            width: 400px;
            height: 500px;
            display: flex;
            flex-direction: column;
            background-color: green;

            li{
                width: 100%;
                height: 100px;
                font-size: 16px;
                padding-left: 20px;
            }

            li:nth-child(1){
                margin-top: 20px;
            }
        }
    }
}
</style>