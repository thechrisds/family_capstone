<template>
    <div class="edit-container">
        <b-button> Add Prize</b-button>
        <h2> Edit a Prize </h2>
        <br/>
        <b-form>
        <b-form-input v-model="prize.name" placeholder="Prize Name"/>
        <br/>
        <b-form-input v-model="prize.description" placeholder="Prize Description"/>
        <br/>
        <b-form-input v-model="prize.goal" placeholder="Reading Goal (Minutes)"/>
        <br/>
        <b-form-input v-model="prize.stock" placeholder="Quantity"/>
        <br/>
        <b-form-datepicker v-model="prize.start_date" placeholder="Select Start Date"/>
        <b-form-datepicker v-model="prize.end_date" placeholder="Select End Date"/>
        <br/>
        <div class="div-button">
            
        <b-button @click="$router.go(-1)"> Go Back </b-button>
        <b-button v-on:click="editPrize()"> Submit</b-button>
        </div>
        </b-form>
    </div>
</template>

<script>
import prizeService from '@/services/PrizeService.js';

export default {
    props: [""],
    name: 'edit-prize',
    data(){
        return{
            prize: {
                name: "",
                family_id: "",
                prize_id: "",
                description: "",
                goal: "",
                stock: "",
                start_date: "",
                end_date: ""
            },
            prizes: []
        }
    },
    created(){
        prizeService.getPrizes().then(response =>{
            this.prizes = response.data;
            this.prizes.forEach( (prize) => {
                if (prize.prize_id == this.$route.params.id){
                    this.prize = prize;
                }
            })
        })

    },
    methods: {
        editPrize(){
            prizeService.editPrize(this.prize).then(response =>{
                if (response.status === 200){
                    alert("Success!");
                    this.$router.push({name: 'prizes'})
                }
            })
        }
    }
}
</script>

<style>
.edit-container{
    margin: auto;
    width: 50%;
    height: 550px;
    background-color: #f2f2f2;
    justify-content:center;
    padding: 15px;
}

.div-button{
    display:flex;
    justify-content: space-between;
}
</style>