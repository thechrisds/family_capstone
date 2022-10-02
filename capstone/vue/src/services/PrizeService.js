import axios from 'axios';


export default {
    getPrizes(){
        return axios.get('/prizes')
    },

    editPrize(prize){
        return axios.put('/prizes', prize);
    }
}