<template>
    <div class="suggest_body">
        <h1 class="suggest_topic">商品推荐列表</h1>
        <ul>
            <router-link v-for="sugge in suggestList" :key="sugge.id" :to="'/Goods/'+sugge.id"  tag="li" @click="saveClick(sugge)"> 
            <li>
                <a href="#">
                    <img :src=sugge.imgurl />
                </a>
                <div class="content_body">
                    <div class="content_name">
                    {{ sugge.goodsName }}
                    </div>
                    <div class="content_popular">
                    ¥{{ sugge.goodsPrice }}
                    {{ sugge.goodstips1 }}  {{ sugge.goodstips2 }}  {{ sugge.goodstips3 }}
                    </div>
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
            suggestList:[],

        }
    },
    mounted:function(){
        setTimeout(async()=>{
            await this.getSuggestList()
        },500)
    },
    methods:{
        getSuggestList(){
            if(this.stores.state.user.userinfo.isonline){
                axios.post('http://localhost:8080/GetSuggest',{
                    uid:this.stores.state.user.userinfo.id,
                }).then((res)=>{
                    this.suggestList=res.data
                }).catch((error)=>{
                    console.log(error)
                })
            }else{
                axios.get('http://localhost:8080/GetRandomSuggest').then((res)=>{
                    this.suggestList=res.data
                }).catch((error)=>{
                    console.log(error)
                })
            }
        },
        saveClick(sugge){
            axios.post('http://localhost:8080/setDainji',{
                uid:this.stores.state.user.userinfo.id,
                gid:sugge.id,
                clicknum:1
            }).catch((error)=>{
                console.log(error)
            }),
            axios.post('http://localhost:8080/addclick',{
                uid:this.stores.state.user.userinfo.id,
                userName:this.stores.state.user.userinfo.userName,
                userInterest1:sugge.goodstips1,
                userInterest2:sugge.goodstips2,
                userInterest3:sugge.goodstips3,
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
.suggest_body{
    position: absolute;
    overflow: auto;
    width: 950px;
    height: 1000px;
    top: 350px;
    left: 250px;

    ul{
        li{
            display: flex;
            height: 150px;
            width: 900px;
            line-height: 30px;
            margin: 20px;
            img{
                width:120px;
                height:120px;
                text-align: center;
            }
            .content_body{
                display: flex;
                flex-direction: column;
                width: 750px;
                height: 150px;
                .content_name{
                    font-size: 26px;
                    width: 750px;
                    height: 70px;
                    border-bottom: 1px solid;
                }
                .content_popular{
                    display: flex;
                    align-items: center;
                    width: 750px;
                    height: 60px;
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