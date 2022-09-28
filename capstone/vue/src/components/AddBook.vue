<template>
     <div class="booklist-container">
         <h2>Add a Book</h2>
         <form class="new-book-form" v-on:submit.prevent="saveBook">
         <input class="title-input" type="text" placeholder="Title" v-model="book.bookTitle" />
         <br />
         <input class="author-input" type="text" placeholder="Author" v-model="book.bookAuthor" />
         <br/>
         <input class="isbn-input" type="text" placeholder="ISBN" v-model.number="book.isbn" required="required"/>
         <br/>
         <input class="genre-input" type="text" placeholder="Genre" v-model.number="book.genre"/>
         <br/>
         <br/>
         <textarea class="description-input" type="text" placeholder="Description..." v-model="book.description"/>
         <br/>
         <button class="submitBook" v-on:click="addBooks()">Save</button>
   </form>
         </div>
</template>

<div>
        <form class="isbn-search" v-on:click.prevent="bookSearch()">
            <input class="isbn-input" type="text" placeholder="ISBN" v-model.number="book.isbn" />
            <button class="submitIsbn">Search</button>
            </form>
            {{bookResults.title}}
            
    </div>





<script>
import bookService from '@/services/BookService.js';
export default{
    name: 'add-book',
    data(){
        return {
            bookResults:[], //the search results from the google api query go here
            book: {
                bookTitle: "",
                bookAuthor: "",
                isbn: "",
                genre: "",
                description: ""
            }
        }
    },
    methods: {
        addBooks(){
            bookService.addBooks(this.book).then(response =>{
                if(response.status === 200){
                    alert("Success!");
                    this.$router.push({name: 'books'})
                } else if (response.status === 500){
                    alert("Adding book failed!")
                }
            })
            this.book = {
                bookTitle: "",
                bookAuthor: "",
                isbn: "",
                genre: "",
                description: ""
            }
            
        },
        checkIfAdded(){
            const allBooks = bookService.seeAll();
            allBooks.forEach((obj) =>{
                if (obj.isbn == this.book.isbn){
                    alert("Book successfully added!")
                }
            })
        },
        bookSearch(){
            bookService.googleBook(this.book.isbn).then(response =>{
                this.bookResults = response.data.items[0].volumeInfo;
            })
            
        }
    }
}
</script>

<style>
.booklist-container{
    margin: auto;
    width: 50%;
    height: 450px;
    background-color: #f2f2f2;
    
    justify-content:center;
    padding: 15px;
    
}
.new-book-form{
    
}

.title-input{
    /* border-top: none;
    border-left: none;
    border-right: none; */
    display: block;
    width: 50%;
  background: #fff;
  border-radius: 31px;
  font-family: Ubuntu-Bold;
  font-size: 18px;
  padding: 0 0 0 10px;
}

.author-input{
    display: block;
    width: 50%;
  background: #fff;
  border-radius: 31px;
  font-family: Ubuntu-Bold;
  font-size: 18px;
  padding: 0 0 0 10px;
    
    
}

.isbn-input{
    display: block;
    width: 50%;
  background: #fff;
  border-radius: 31px;
  font-family: Ubuntu-Bold;
  font-size: 18px;
  line-height: 1.2;
  padding: 0 0 0 10px;
    

}

.description-input {
    box-shadow: 0 0 2px 1px rgba(255, 169, 0, 0.5);
    height: 100px;
    padding: 0 0 0 10px;
    width: 50%;
    border-radius: 20px;
}

.genre-input {
    display: block;
    width: 50%;
  background: #fff;
  border-radius: 31px;
  font-family: Ubuntu-Bold;
  font-size: 18px;
  line-height: 1.2;
  padding: 0 0 0 10px;
}

h2{
    text-align:center;
    
}
 </style>