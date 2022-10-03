<template>
    <div class="add-prize">
        <h2> Add a Prize </h2>
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
        <b-button v-on:click="addPrize()"> Submit</b-button>
        </b-form>
    </div>
</template>



<script>
import prizeService from '@/services/PrizeService.js';
export default {
    name: 'add-prize',
    data(){
        return {
            prize: {
                name: "",
                description: "",
                goal: 0,
                stock: 0,
                start_date: "",
                end_date: ""
            }

        }
    },
    methods: {
        addPrize(){
            prizeService.createPrize(this.prize).then(response =>{
                if (response.status === 200){
                    alert("Success!");
                    this.$router.push({name: 'prizes'})
                } else if (response.status === 500){
                    alert("Adding Prize Failed!");
                }
            })
            this.prize = {
                name: "",
                description: "",
                goal: 0,
                stock: 0,
                start_date: "",
                end_date: ""
            }
        }
    }
    
}
</script>

<style>
.add-prize {
    margin: auto;
    width: 50%;
    height: 550px;
    background-color: #f2f2f2;
    margin-top: 200px;
    justify-content:center;
    padding: 15px;
}

.sizing {
    
}

</style>