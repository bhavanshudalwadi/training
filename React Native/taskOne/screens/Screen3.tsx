import { Alert, AlertIcon, AlertText, ArrowRightIcon, Button, ButtonText, Card, FormControl, FormControlHelper, FormControlHelperText, FormControlLabelText, GluestackUIProvider, HStack, Heading, Icon, Image, InfoIcon, Input, InputField, Link, LinkText, ScrollView, Text, View } from "@gluestack-ui/themed"
import { config } from "@gluestack-ui/config"
import React from 'react'
import { StyleSheet } from "react-native"
import { FormControlLabel } from "@gluestack-ui/themed"

const Screen3 = () => {
  return (
    <GluestackUIProvider config={config}>
      <ScrollView style={styles.container}>
        <Button>
          <ButtonText>Button</ButtonText>
        </Button>
        <Alert mx="$2.5" action="info" variant="solid">
          <AlertIcon as={InfoIcon} mr="$3" />
          <AlertText>
            Info Alert
          </AlertText>
        </Alert>
        <Card p="$5" borderRadius="$lg" maxWidth={360} m="$3">
          <Image
            mb="$6"
            h={240}
            width="$full"
            alt="Failed to load image"
            borderRadius="$md"
            source={{
              uri: "data:image/jpeg;base64,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",
            }}
          />
          <Text
            fontSize="$sm"
            fontStyle="normal"
            fontFamily="$heading"
            fontWeight="$normal"
            lineHeight="$sm"
            mb="$2"
            sx={{
              color: "$textLight700",
              _dark: {
                color: "$textDark200",
              },
            }}
          >
            May 15, 2023
          </Text>
          <Heading size="md" fontFamily="$heading" mb="$4">
            The Power of Positive Thinking
          </Heading>
          <Link href="https://gluestack.io/" isExternal>
            <HStack alignItems="center">
              <LinkText
                fontFamily="$heading"
                fontWeight="$semibold"
                color="$primary600"
                $dark-color="$primary300"
                textDecorationLine="none"
              >
                Read Blog
              </LinkText>
              <Icon
                as={ArrowRightIcon}
                color="$primary600"
                mt="$0.5"
                ml="$0.5"
                $dark-color="$primary300"
              />
            </HStack>
          </Link>
        </Card>
        <FormControl minWidth="$50" style={{ marginBottom: 50 }}>
          <FormControlLabel>
            <FormControlLabelText>Full Name</FormControlLabelText>
          </FormControlLabel>
          <Input>
            <InputField type="text" />
          </Input>
        </FormControl>
        <View style={{flex: 1, flexDirection: 'row',alignItems: 'center'}}>
            <View>
              <Icon
                as={ArrowRightIcon}
                color="$primary600"
                $dark-color="$primary300"
              />
            </View>
            <View style={{alignItems: 'center',flexGrow: 1}}><Text>Trending</Text></View>
            </View>
      </ScrollView>
    </GluestackUIProvider>
  )
}

const styles = StyleSheet.create({
  container: {
    paddingHorizontal: 16,
    paddingVertical: 20,
  }
});

export default Screen3;
