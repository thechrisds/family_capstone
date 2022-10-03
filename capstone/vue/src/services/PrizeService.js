import axios from 'axios';


export default {
    getPrizes(){
        return axios.get('/prizes')
    },

    editPrize(prize){
        return axios.put('/prizes', prize);
    },

    createPrize(prize){
        return axios.post('/prizes', prize);
    },
    
    deletePrize(id){
        return axios.delete(`/prizes/${id}`);
    }
}