<template>
    <div id="all-books">
    <view-book />
    <div class="booklist">
    <router-link to="/books/add"> Add A Book To Library </router-link>
    </div>
    </div>
</template>

<script>
import ViewBook from '@/components/ViewBook'

export default ({
    components: {
        ViewBook
    }
});
</script>

<style>
.booklist{
    text-align:center;
}
</style>
