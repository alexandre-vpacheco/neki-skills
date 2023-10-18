import React from "react";
import { StyleSheet, Text, TouchableOpacity} from 'react-native'



const EntrarButton = ({ onpress }) => {
    return (
        <TouchableOpacity style={styles.button}
           onPress={onpress} >
            <Text style={styles.buttonText}>Entrar</Text>
        </TouchableOpacity>

    )
}

export default EntrarButton

const styles = StyleSheet.create({

    button: {
        marginTop: 15,
        backgroundColor: '#F5F6F6',
        borderRadius: 15,
        width: 170,
        height: 40,
        alignItems: 'center',
        justifyContent: 'center'
    },

    buttonText: {
        fontSize: 17
    }
})