import React, { useState } from 'react';
import { StyleSheet, Text, View, Image, Modal } from 'react-native';
import SairButton from '../../Components/SairButton';
import { useNavigation } from '@react-navigation/native';
import Loading from '../../Components/Loading';

export default function HomePage() {

    const [visible, setVisible] = useState(false);

    const [modalVisible, setModalVisible] = useState('');

    const navigation = useNavigation();

    const sair = () => {
        setVisible(true);
        setTimeout(() => {
            setVisible(false);
            navigation.navigate('Login')
        }, 500)
    }

    return (
        <>
            <View style={styles.container1}>
                <Loading visible={visible} />
                <Text style={styles.txt}>Home</Text>
                <SairButton onpress={sair} />
            </View>
        </>
    );
}

const styles = StyleSheet.create({

    header: {
        marginTop: 35,
        flexDirection: 'row',
        alignItems: 'flex-start',
    },

    container1: {
        flexDirection: 'column',
        flex: 1,
        backgroundColor: '#4682B4',
        alignItems: 'center',
        //justifyContent: 'center',
    },

    txt: {
        borderTopWidth: 2,
        borderBottomWidth: 2,
        borderTopColor: 'black',
        borderBottomColor: 'black',
        padding: 20,
        fontWeight: 'bold',
        fontSize: 22,
        color: 'white',
        marginTop: 55,
        alignItems: 'center'
    },

});