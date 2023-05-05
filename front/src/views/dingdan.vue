<template>
    <div class="bcimg">
    <h1 class="title">订单</h1>
    <div class="GouwuBody">
    <ul>
        <li v-for="dingdan in dingdanList" :key="dingdan.id">
            <div class="imgbox">
                <div class="top_img">
                    <img :src=dingdan.imgurl />
                </div>
            </div>
            <div class="informbox">
                <ul>
                    <li>商品名称：{{ dingdan.goodsName }}</li>
                    <li>
                        <div>商品数量：{{ dingdan.goodsNum }}</div>
                        <div>商品价格：¥{{ dingdan.totalPrice }}</div>
                    </li>
                    <li>配送地址:{{ dingdan.userAddress }}</li>
                </ul>
            </div>
        </li>
    </ul>
    
  </div>
</div>
</template>

<script >
import axios from 'axios'
import { useStore } from 'vuex'
export default {
    data() {
        const stores=useStore()

      return {
        dingdanList:[],
        stores,
      }
    },
    methods:{
        getDingdan(){
            axios.post('http://localhost:8080/GetDingdan',{
            uid:this.stores.state.user.userinfo.id
            }).then((res)=>{
                this.dingdanList=res.data,
                console.log(res.data)
            }).catch((error)=>{
                console.log(error)
            })
        }
        },
    mounted:function(){
        this.getDingdan()
    }
}
</script>

<style lang="less" scoped>
.bcimg{
    width: 100%;
    height: 753px;
    background-image: url("../assets/images/dingdan.jpg");
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
                width: 200px;
                height: 200px;
                display: flex;
                flex-direction: column;
                background-color: rgba(0, 128, 0, 0.341);
                justify-content: center;
                align-items: center;
                margin-top: 5px;
                .top_img{
                    width: 200px;
                    height: 200px;
                    background-color: antiquewhite;

                    img{
                    width: 100%;
                    height: 100%;
                }
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
    width: 600px;
    height: 212px;
    display: flex;
    flex-direction: column;
    ul{
        width: 600px;
        height: 210px;
        li{
            width: 600px;
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