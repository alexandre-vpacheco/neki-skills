import { StyleSheet, Text, View, Image, Modal } from 'react-native';

export default function MenuLateral({ modalVisible }) {
    return (
        <Modal transparent visible={modalVisible} >
            <View style={styles.container}>
                <Text>Menu Lateral</Text>
            </View>
        </Modal>
    );
}

const styles = StyleSheet.create({

    container: {
        flex: 1,
        backgroundColor: 'white',
        height: 100,
        width: 100,
    }

}); 