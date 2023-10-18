import {
    StyleSheet,
    Text,
    View,
    TextInput,
    TouchableOpacity,
}
    from 'react-native';
import { useState, useContext } from 'react';
import { useNavigation } from '@react-navigation/native';
import Loading from '../../Components/Loading';
//import AxiosInstance from '../../api/AxiosInstance';
//import { DataContext } from '../../context/DataContext';

const Login = () => {

    const navigation = useNavigation();

    const [visible, setVisible] = useState(false);

    const [usuario, setUsuario] = useState('');

    const [senha, setSenha] = useState('');
    //const { armazenarDadosUsuario } = useContext(DataContext);

    const handleLogin = async () => {
        console.log('Login clicado')
        console.log('Usuario', { usuario }, 'Senha digitada:', { senha });

        if (usuario == '' && senha == '') {
            setVisible(true);
            setTimeout(() => {
                setVisible(false);
                navigation.navigate("HomePage");
            }, 500)
        } else {
            console.log('Erro ao realizar o login');
        }
    }

    const handleCadastro = async () => {
        console.log('Cadastro clicado')       
            setVisible(true);
            setTimeout(() => {
                setVisible(false);
                navigation.navigate("Cadastro");
            }, 500)
    }

    return (
        <View style={styles.container}>
            <Loading visible={visible}/>
            <Text style={styles.txt}>Sistema Skill</Text>
            <TextInput
                style={styles.input}
                placeholder="Usuário"
                onChangeText={setUsuario}
                value={usuario}
            />
            <TextInput
                style={styles.input}
                placeholder="Senha"
                onChangeText={setSenha}
                value={senha}
            />
            <TouchableOpacity style={styles.button} onPress={() => handleLogin()}>
                <Text style={styles.txtButton}>Login</Text>
            </TouchableOpacity>
            <Text style={styles.txt2}>ou</Text>
            <TouchableOpacity style={styles.button} onPress={() => handleCadastro()}>
                <Text style={styles.txtButton}>Cadastre-se</Text>
            </TouchableOpacity>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#4682B4',
        alignItems: 'center',
        justifyContent: 'center',
    },
    txt: {
        fontSize: 22,
        marginBottom: 50,
        backgroundColor: 'black',
        color: 'white',
        borderTopLeftRadius: 20,
        borderBottomRightRadius: 20,
        padding: 20,

    },

    txt2: {
        fontSize: 15,
        marginBottom: -5,
        marginTop: 10,
        color: 'white',
    },

    input: {
        width: 280,
        height: 40,
        margin: 12,
        borderWidth: 1,
        padding: 10,
        borderRadius: 15,
    },
    button: {
        width: 150,
        marginTop: 20,
        alignItems: 'center',
        backgroundColor: 'black',
        padding: 9,
        borderRadius: 10,
    },
    txtButton: {
        color: 'white'
    },

});

export default Login;