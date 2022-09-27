import axios from 'axios';



export default {

    seeBooks(){
      return axios.get('/books');
    },
    
    addBooks(book){
        return axios.post('/books', book);
    }
  }
