import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Link } from 'expo-router'
import { CheckCircleIcon, Icon } from '@gluestack-ui/themed'

const Home = () => {
  return (
    <View>
        <Icon as={CheckCircleIcon} m="$2" w="$4" h="$4" />
    </View>
  )
}

export default Home

const styles = StyleSheet.create({})