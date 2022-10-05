<template>
    <div class="prizes-main-container">
        
        <prize-table />
        <div id="delete">
        <!-- <b-button v-b-modal.modal-1 v-on:click="deletePrize()" hide-footer> Delete Selected Prize? </b-button> -->

        <b-button v-on:click="confirmDelete">Delete Selected Prize</b-button>
        <b-button v-on:click="sendToEdit">Edit Selected Prize</b-button>
        </div>
    </div>
</template>

<div class="test">
        <b-button> Add Prize </b-button>
        </div>

<script>
import prizeTable from '@/components/PrizeTable'
import prizeService from '@/services/PrizeService.js';

export default {
    components: {
        prizeTable
    },
    data(){
        return {
            prize: [],
            boxOne: '',
            boxTwo:'',
            editedPrize: {
                prize_id: 0,
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
        sendToEdit(){

        },
        deletePrize(){
          prizeService.deletePrize(this.$store.state.prize.prize_id);
          

        },
        confirmDelete(){
            this.boxOne = ''
            this.$bvModal.msgBoxConfirm('Are you sure you want to delete this prize?').then(value => {
                if (value === true){
                    prizeService.deletePrize(this.$store.state.prize.prize_id);
                    this.$router.go({name: 'prizes'})
                }
            })
            
        },
        editPrize(){
            this.boxTwo = ''
            this.$bvModal.msgBoxConfirm('Are you sure you want to delete this prize?').then(value => {
                if (value === true){
                    prizeService.deletePrize(this.$store.state.prize.prize_id);
                    this.$router.go({name: 'prizes'})
                }
            })
            
        }

    },
    created(){
        
    }
};
</script>

<style>
.prizes-main-container{
    margin-top:100px;
    display:flex;
  flex-direction: column;
}



#delete{
    display:flex;
    justify-content: space-between;
    max-width: 350px;
    margin-top:20px;
    margin-left:100px;
}
</style>