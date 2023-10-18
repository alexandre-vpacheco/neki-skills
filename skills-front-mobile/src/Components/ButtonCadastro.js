import React from "react";
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'



const ButtonCadastro = ({ onpress }) => {
    return (
        <TouchableOpacity style={styles.button}
           onPress={onpress} >
            <Text style={styles.buttonText}>Cadastre-se</Text>
        </TouchableOpacity>

    )
}

export default ButtonCadastro

const styles = StyleSheet.create({

    button: {
        marginTop: 10,
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