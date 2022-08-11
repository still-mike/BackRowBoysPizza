<template>
    <div>
        <div id = 'PromoBanner' v-if="isBannerDisplayed ===true">
            <div class = "bannerText"><h1>use code 'brb15' for 15% off!</h1></div>
            <div class = 'bannerExit'><button type ='button' class = 'bannerExit' v-on:click="changeBannerDisplay">X</button></div>
        </div>
        <div id = 'NavBar'>
            <nav>
                <a href="/contactUs" class='NavLink'>contact</a>
                <a href="/aboutUs" class='NavLink'>about us</a>
                <a href="/orderNow" class='NavLink'>order now</a>
                <a href="/" class='NavLink'>home</a>
            </nav>
        </div>
    </div>
</template>

<script>
export default {
    name: "website-header", 
    computed: {
        isBannerDisplayed() {
            return this.$store.state.isBannerDisplayed
            
        }
    
    },
    methods: {
        changeBannerDisplay() {
            console.log(this.$store.state.isBannerDisplayed)
            this.$store.commit("SET_BANNER_DISPLAY");
        }
    }
}
</script>

<style>

</style>