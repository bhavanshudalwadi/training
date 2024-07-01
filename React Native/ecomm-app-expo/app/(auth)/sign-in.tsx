import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Link } from 'expo-router'

const SignIn = () => {
  return (
    <View>
      <Text>SignIn</Text>
      <Link href='/home'>Home</Link>
    </View>
  )
}

export default SignIn

const styles = StyleSheet.create({})