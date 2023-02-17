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
      var instance = axios.create();
      return instance.get('https://openlibrary.org/search.json?q=isbn:' + isbn);
        
        
        //delete instance.defaults.headers.common['Authorization'];
    },
    
    editBook(book){
      return axios.put('/books', book);
    },

    deleteBook(book){
      return axios.put('/books/delete', book);
    }
  }
