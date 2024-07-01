import { FlatList, ScrollView, StyleSheet, Text, TextInput, View } from 'react-native'
import React from 'react'
import Card from '../components/Card'
import { Image } from 'react-native'

const fashionList = [
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    }
]

const electronicsList = [
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    },
    {
        title: "Man's Fashion",
        img: "https://uniqueandclassy.com/cdn/shop/products/16_Hed874f9e7cd8420398d53214ee361d0fB_95a8c86e-728d-4ca3-a9b1-5b8ba9b525fa.jpg?v=1622734129"
    }
]

export default function Screen1({ navigation }: any) {
    return (
        <View style={{flex: 1}}>
            <View style={styles.searchSection}>
                <View style={styles.searchIconContainer}>
                    <Image source={{uri: 'https://cdn-icons-png.flaticon.com/128/7168/7168043.png'}} style={styles.searchIcon}/>
                </View>
                <TextInput
                    style={styles.input}
                    placeholder="Search products & brands"
                    onChangeText={(searchString) => {console.log(searchString)}}
                    underlineColorAndroid="transparent"
                />
            </View>
            <ScrollView style={{paddingHorizontal: 16}}>
                <Text style={styles.header}>Fashion</Text>
                <FlatList
                    numColumns={3}
                    data={fashionList}
                    renderItem={({ item }) => (
                        <Card title={item.title} img={item.img} />
                    )}
                    keyExtractor={(item, index) => item.title + " " + index}
                    scrollEnabled={false}
                />
                <View style={{ backgroundColor: '#999', width: '100%', height: 1, marginTop: 30 }}></View>
                <Text style={styles.header}>Mobile & Electronics</Text>
                <FlatList
                    numColumns={3}
                    data={electronicsList}
                    renderItem={({ item }) => (
                        <Card title={item.title} img={item.img} />
                    )}
                    keyExtractor={(item, index) => item.title + " " + index}
                    scrollEnabled={false}
                />
            </ScrollView>
        </View>
    )
}

const styles = StyleSheet.create({
    header: {
        fontSize: 25,
        marginVertical: 20,
        textAlign: 'center',
        fontWeight: 'bold'
    },
    searchSection: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'deeppink',
        paddingTop: 35,
        paddingBottom: 35,
        paddingHorizontal: 16,
        height: 60,
    },
    searchIcon: {
        width: 30,
        height: 30,
        alignSelf: 'center',
    },
    searchIconContainer: {
        height: 50,
        width: 50,
        justifyContent: 'center',
        backgroundColor: '#fff',
        borderTopLeftRadius: 5,
        borderBottomLeftRadius: 5
    },
    input: {
        flex: 1,
        paddingTop: 10,
        paddingRight: 10,
        paddingBottom: 10,
        paddingLeft: 0,
        backgroundColor: '#fff',
        color: '#424242',
        height: 50,
        borderTopRightRadius: 5,
        borderBottomRightRadius: 5
    },
})