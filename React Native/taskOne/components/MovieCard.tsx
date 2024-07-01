import { View, Text, TouchableHighlight, StyleSheet, Image, ViewToken } from 'react-native'
import React, { PropsWithChildren, memo } from 'react'
import Animated, { SharedValue, interpolate, useAnimatedStyle, withTiming } from 'react-native-reanimated';

type MovieCardProps = {
    title: string,
    img: string,
    imdb_rating: number,
    date_of_release: string,
    watch_count: number
    viewableItems: SharedValue<ViewToken[]>
};

const MovieCard: React.FC<MovieCardProps> = ({title, img, imdb_rating, date_of_release, watch_count, viewableItems}) => {

    const rStyle = useAnimatedStyle(() => {
        const isVisible = Boolean(viewableItems.value
            .filter((item) => item.isViewable)
            .find((viewableItem) => viewableItem.item.title === title)
        )
        return {
            opacity: withTiming(isVisible ? 1 : 0),
            transform: [{
                scale: withTiming(isVisible ? 1 : 0.3),
            }]
        };
    }, [])

  return (
    <Animated.View style={[styles.item, rStyle]}>
        {/* <TouchableHighlight style={styles.item} underlayColor={"#ccc"} onPress={() => {}}> */}
            <View style={{flex: 1, flexDirection: 'row'}}>
                <Image style={styles.cardImg} source={{uri: img}} />
                <View style={{flexGrow: 1}}>
                    <View style={{flex: 1, flexDirection: 'column'}}>
                        <View style={{flexGrow: 1, paddingHorizontal: 15, paddingVertical: 10}}>
                            <Text style={styles.cardTitle}>{title}</Text>
                        </View>
                        <View style={{flexGrow: 20, padding: 15, flex: 1, flexDirection: 'row'}}>
                            <Text style={styles.imdbRatings}>{imdb_rating}</Text>
                            <View style={{flexGrow: 1, flex: 1, flexDirection: 'column'}}>
                                <Text style={styles.releaseDate}>{date_of_release}</Text>
                                <Text>{watch_count} Watched</Text>
                            </View>
                        </View>
                    </View>
                </View>
            </View>
        {/* </TouchableHighlight> */}
    </Animated.View>
  )
}

const styles = StyleSheet.create({
    item: {
        marginVertical: 8,
        width: '90%',
        alignSelf: 'center',
        borderRadius: 15,
        borderWidth: 1,
        borderColor: '#999',
        height: 150,
    },
    cardImg: {
        width: 150,
        height: 148,
        borderTopLeftRadius: 10,
        borderBottomLeftRadius: 10,
    },
    cardTitle: {
        fontSize: 25,
        fontWeight: 'bold',
        marginVertical: 10
    },
    imdbRatings: {
        fontSize: 40,
        fontWeight: 'bold',
        marginRight: 10
    },
    releaseDate: {
        fontWeight: 'bold'
    }
})

export default memo(MovieCard);