<template>
     <div class="booklist-container">
         <form class="new-book-form" v-on:submit.prevent="saveBook">
         <input class="title-input" type="text" placeholder="Title" v-model="book.bookTitle" />
         <br />
         <input class="author-input" type="text" placeholder="Author" v-model="book.bookAuthor" />
         <br/>
         <input class="isbn-input" type="text" placeholder="ISBN" v-model.number="book.isbn" required="required"/>
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
                genre: "z",
                description: "No description given"
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
                genre: "z",
                description: "No description given"
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
    padding: 200px;
    margin: auto;
    margin-top: 100px;
    justify-content: center;
    border:black 2px solid;
    width: 35%;
    height: 300px;
}
.new-book-form{
    
}

.title-input{
    border-top: none;
    border-left: none;
    border-right: none;
    font-size: 16px;
    font-weight: 500;
    
}

.author-input{
    margin: 10px auto;
    box-shadow: 1px 1px 4px;
}

.isbn-input{
    margin: 10px auto;
    box-shadow: 1px 1px 4px;

}
</style>