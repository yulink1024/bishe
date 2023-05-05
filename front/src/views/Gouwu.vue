<template>
    <div class="bcimg">
    <h1 class="title">购物车</h1>
    <div class="GouwuBody">
    <ul>
        <li v-for="gouwu in gouwucheList" :key="gouwu.id">
            <div class="imgbox">
                <div class="top_img">
                    <img :src=gouwu.imgurl />
                </div>
                <div class="choosebtn">
                    <el-button type="success" @click="buyIt(gouwu)">购买</el-button>
                    <el-button type="danger" @click="deleteGouwu(gouwu.id)">删除</el-button>
                </div>
            </div>
            <div class="informbox">
                <ul>
                    <li>商品名称：{{ gouwu.goodsName }}</li>
                    <li>
                        <div>商品数量：{{ gouwu.goodsNum }}</div>
                        <div>商品价格：¥{{ gouwu.totalPrice }}</div>
                    </li>
                    <li>配送地址:{{ stores.state.user.userinfo.userAddress }}</li>
                </ul>
            </div>
        </li>
    </ul>
    
  </div>
</div>
</template>

<script>
import axios from 'axios'
import { useStore } from 'vuex'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
export default {
    data() {
        const stores=useStore()
        const router=useRouter()
      return {
        gouwucheList:[],
        stores,
        router
      }
    },
    methods:{
        buyIt(gouwu){
            axios.post('http://localhost:8080/AddDingdan',{
                uid:this.stores.state.user.userinfo.id,
                gid:gouwu.goodid,
                imgurl:gouwu.imgurl,
                goodsName:gouwu.goodsName,
                goodsNum:gouwu.goodsNum,
                totalPrice:gouwu.totalPrice,
                userAddress:this.stores.state.user.userinfo.userAddress
                }).then((res)=>{
                    if(res.data){
                            ElMessage({
                            message: "购买成功",
                            type:'success'
                        }),
                        this.deleteGouwu(gouwu.id)
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
                userInterest1:gouwu.goodstips1,
                userInterest2:gouwu.goodstips2,
                userInterest3:gouwu.goodstips3,
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
        },

        getGouwu(){
            axios.post('http://localhost:8080/GetGouwucheByUid',{
            uid:this.stores.state.user.userinfo.id
            }).then((res)=>{
                this.gouwucheList=res.data,
                console.log(res.data)
            }).catch((error)=>{
                console.log(error)
            })
        },
        deleteGouwu(id){
            axios.post('http://localhost:8080/DeleteGouwu',{
                id:id
            }).then((res)=>{
                if(res.data){
                    this.getGouwu()
                }else{
                    ElMessage({
                        message:"出错了，请重试",
                        type:"error"
                    })
                }
            }).catch((error)=>{
                console.log(error)
            })
        }
    },
    mounted:function(){
        this.getGouwu()
    },
}
</script>

<style lang="less" scoped>
.bcimg{
    width: 100%;
    height: 753px;
    background-image: url("../assets/images/Gouwuche.jpg");
    background-size: 100% 100%;
}

.title{
    text-align: center;
    padding-top: 25px;
    color: red;
}
.GouwuBody{
    
    width: 900px;
    height: 500px;
    position: absolute;
    top: calc(50% - 250px);
    left: calc(50% - 450px);
    background-color: rgba(255, 0, 0, 0.201);
    overflow: auto;
    padding: 20px;
    display: flex;
    align-items: center;
    justify-content: center;

    ul{
        width: 800px;
        height: 500px;
        li{
            width: 800px;
            height: 212px;
            display: flex;
            background-color: rgba(0, 255, 255, 0.31);
            
            .imgbox{
                width: 150px;
                height: 200px;
                display: flex;
                flex-direction: column;
                background-color: rgba(0, 128, 0, 0.341);
                justify-content: center;
                align-items: center;
                margin-top: 5px;
                .top_img{
                    width: 150px;
                    height: 150px;
                    background-color: antiquewhite;

                    img{
                    width: 100%;
                    height: 100%;
                }
                }

                .choosebtn{
                    width: 150px;
                    height: 50px;
                    display: flex;
                    align-items: center;
                    justify-content: center;

                }
            }
        }

        li:hover{
                color: @xtxColor;
                border-bottom: 2px solid @xtxColor;
                }
        } 
}

.informbox{
    width: 650px;
    height: 212px;
    display: flex;
    flex-direction: column;
    ul{
        width: 650px;
        height: 210px;
        li{
            width: 650px;
            height: 70px;
            line-height: 3;
        }

        li:hover{
            border: 0;
        }

        li:nth-child(2){
            display: flex;
            flex-direction: column;
            div{
                height: 35px;
            }
        }
    }
}
            
</style>