import axios from 'axios';



export default {
    seeBooks(){
      return axios.get('/books');
    }
  }
