import React, { useEffect, useState } from 'react'
import AsyncStorage from '@react-native-async-storage/async-storage';
import { AddIcon, Button, ButtonIcon, ButtonText, CloseCircleIcon, CloseIcon, GluestackUIProvider, Heading, Input, InputField, TrashIcon, View } from '@gluestack-ui/themed';
import { config } from '@gluestack-ui/config';
import { Alert, FlatList, StyleSheet } from 'react-native';
import { Card } from '@gluestack-ui/themed';
import { TouchableOpacity } from 'react-native';

export type Item = {
    id: number,
    text: string
}

const Screen6 = () => {
    const [input, setInput] = useState<string>("")
    const [items, setItems] = useState<Item[]>([])

    useEffect(() => {
        getData();
    }, [])

    const storeData = async (item: Item) => {
        try {
            const jsonArray = JSON.stringify([...items, item]);
            await AsyncStorage.setItem('items', jsonArray);
            getData();
        } catch (e) {
            console.log("Error: ", e)
        }
    };

    const getData = async () => {
        try {
            const jsonArray = await AsyncStorage.getItem('items');
            setItems(jsonArray != null ? JSON.parse(jsonArray) : []);
        } catch (e) {
            console.log("Error: ", e)
        }
    };

    const addData = () => {
        if(input != '') {
            storeData({ id: (Math.random() * 9999999), text: input })
            setInput("")
        }else {
            Alert.alert('Opps!', 'Please enter valid input', [
                {
                  text: 'Cancel',
                  onPress: () => console.log('Cancel Pressed'),
                  style: 'cancel',
                },
                {text: 'OK', onPress: () => console.log('OK Pressed')},
            ]);
        }
    }

    const removeItem = async (item: Item) => {
        const newItems = items.filter(i => i.id != item.id);
        const jsonArray = JSON.stringify(newItems);
        await AsyncStorage.setItem('items', jsonArray);
        getData();
    }

    return (
        <GluestackUIProvider config={config}>
            <View style={styles.mainContainer}>
                <View style={styles.itemsContainer}>
                    <FlatList
                        style={{ paddingHorizontal: 16 }}
                        data={items}
                        renderItem={({ item }) => (
                            <Card size="md" variant="elevated" elevation={3} marginHorizontal="$1" marginVertical="$2">
                                <View style={{flex: 1, flexDirection: 'row'}}>
                                    <Heading style={{flexGrow: 1}} size="md">
                                        {item.text}
                                    </Heading>
                                    <TouchableOpacity onPress={() => removeItem(item)}>
                                        <ButtonIcon size='xl' as={TrashIcon} />
                                        {/* <ButtonIcon size='xl' as={CloseIcon} />
                                        <ButtonIcon size='xl' as={CloseCircleIcon} /> */}
                                    </TouchableOpacity>
                                </View>
                            </Card>
                        )}
                        keyExtractor={(item, index) => item.id.toString()}
                    />
                </View>
                <View style={styles.addDataContainer}>
                    <Input style={styles.textInput} mr="$2">
                        <InputField value={input} type="text" onChangeText={setInput} />
                    </Input>
                    <View style={styles.buttonContainer}>
                        <Button
                            onPress={addData}
                            size="md"
                            variant="solid"
                            action="positive"
                            isDisabled={false}
                            isFocusVisible={true}
                        >
                            <ButtonText>Add </ButtonText>
                            <ButtonIcon as={AddIcon} />
                        </Button>
                    </View>
                </View>
            </View>
        </GluestackUIProvider>
    )
}

export default Screen6

const styles = StyleSheet.create({
    mainContainer: {
        flex: 1,
        marginBottom: 10
    },
    addDataContainer: {
        flex: 1,
        marginHorizontal: 25,
        flexDirection: 'row',
        position: 'absolute',
        bottom: 0,
        alignItems: 'center'
    },
    textInput: {
        flexGrow: 15,
    },
    buttonContainer: {
        flexGrow: 1
    },
    itemsContainer: {
        flexGrow: 1,
        marginBottom: 50
    }
})