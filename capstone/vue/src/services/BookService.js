import axios from 'axios';



export default {

    seeBooks(){
      return axios.get('/books');
    },
    
    addBooks(book){
        return axios.post('/books', book);
    },
    googleBook(isbn){
      return axios.get('https://www.googleapis.com/books/v1/volumes?q=' + isbn);
    }
  }
