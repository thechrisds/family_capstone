import axios from 'axios';



export default {

    seeBooks(){
      return axios.get('/books');
    },
    
    addBooks(book){
        return axios.post('/books', book);
    },

    seeOpenBooks(){
      return axios.get('/books/all')
    },
    
    googleBook(isbn){
      return axios.get('https://www.googleapis.com/books/v1/volumes?q=' + isbn);
    },
    
    editBook(book){
      return axios.put('/books', book);
    },

    deleteBook(book){
      return axios.put('/books/delete', book);
    }
  }
