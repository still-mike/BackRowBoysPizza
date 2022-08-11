<template>
    <div id ='footer'>
        <p id ="CopyRight"> &#169; 2022 tech elevator designz</p>
        <div><a  id ="InstaLink" href="https://www.instagram.com/backrowboyzpizza/" class="fa fa-instagram"></a></div>
        <div id= "EmployeeLogin"><router-link class = "LoginLink" :to="{ name: 'login' }">login</router-link></div>
        <!-- <a id= "EmployeeLogin" href="LoginFromMike">login</a> -->
    </div>
</template>

<script>
export default {
    name: "website-footer"

}
</script>

<style>

</style>