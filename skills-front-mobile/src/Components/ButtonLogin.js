import React from "react";
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'


const ButtonLogin = ({ onpress }) => {
    return (
        <TouchableOpacity style={styles.button}
            onPress={onpress}>
            <Text style={styles.buttonText}>Fazer Login</Text>
        </TouchableOpacity>

    )
}

export default ButtonLogin

const styles = StyleSheet.create({

    button: {
        marginTop: 200,
        backgroundColor: '#F5F6F6',
        borderRadius: 15,
        width: 190,
        height: 40,
        alignItems: 'center',
        justifyContent: 'center'
    },

    buttonText: {
        fontSize: 17
    }
})