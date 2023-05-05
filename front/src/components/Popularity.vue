<template>
    <div class="popular_body">
        <h1 class="popular_topic">热度榜</h1>
        <ul>
            <router-link v-for="goods in topGoods" :key="goods.id" :to="'/Goods/'+goods.id"  tag="li" @click="saveClick(goods)"> 
                <li>
                    <div class="content">
                        <div>
                            <a href="#">
                                <img :src=goods.imgurl />
                            </a>
                            <div class="hotpoint">
                                热度：{{goods.hotpoint}}
                            </div>
                        </div>
                        <div class="content_body">
                            <div class="content_name">
                                {{ goods.goodsName }}
                            </div>
                            <div class="content_price">
                                ¥{{ goods.goodsPrice }}
                            </div>
                        </div>
                    </div>
                    <div class="tips">
                        <p>{{ goods.goodstips1 }}</p>
                        <p>{{ goods.goodstips2 }}</p>
                        <p>{{ goods.goodstips3 }}</p>
                    </div>
                </li>
            </router-link>
        </ul>

    </div>
</template>

<script>
import axios from 'axios';
import { useStore } from 'vuex'
export default {
    data(){
        const stores=useStore();
        return{
            stores,
            topGoods:[]
        }

    },
    mounted:function(){
        axios.get('http://localhost:8080/getTop').then((res)=>{
            this.topGoods=res.data
        }).catch((error)=>{
            console.log(error)
        })
    },
    methods:{
        saveClick(goods){
            axios.post('http://localhost:8080/setDainji',{
                uid:this.stores.state.user.userinfo.id,
                gid:goods.id,
                clicknum:1
            }).catch((error)=>{
                console.log(error)
            }),
            axios.post('http://localhost:8080/addclick',{
                uid:this.stores.state.user.userinfo.id,
                userName:this.stores.state.user.userinfo.userName,
                userInterest1:goods.goodstips1,
                userInterest2:goods.goodstips2,
                userInterest3:goods.goodstips3,
            }).then((res)=>{
                console.log(res.data)
            }).catch((error)=>{
                console.log(error)
            })
        }
    }
}
</script>

<style lang="less" scoped>

.popular_body{
    width: 250px;
    height: 1300px;
    position: absolute;
    top: 80px;
    right: 0px;
    background-color: red;

    .popular_topic{
        padding: 5px;
        text-align: center;
    }

    ul{
        li{
            display: flex;
            height: 200px;
            width: 250px;
            line-height: 30px;
            margin: 10px;
            flex-direction: column;

            .content{
                height: 180px;
                width: 250px;
                display: flex;
                img{
                width:100px;
                height:100px;
                text-align: center;
                }

                .hotpoint{
                    text-align: center;
                }
                .content_body{
                    display: flex;
                    flex-direction: column;
                    justify-content: space-between;
                    width: 140px;
                    height: 180px;
                    .content_name{
                        width: 140px;
                        height: 150px;
                        font-size: 10px;
                        border-bottom: 1px solid;
                    }
                    .content_price{
                        width: 140px;
                        height: 30px;
                    }
                }
            }
            .tips{
                display: flex;
                line-height: 5px;
                p{
                    margin-left: 25px;
                }
            }
            
        }
        li:hover{
                color: @xtxColor;
                border-bottom: 2px solid @xtxColor;
                }
    }
}
</style>