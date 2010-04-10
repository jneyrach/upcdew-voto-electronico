function trim(cadena){
    for(i=0; i<cadena.length; i++)
    {
        if(cadena.charAt(i)==" ")
            cadena=cadena.substring(i+1, cadena.length);
        else
            break;
    }

    for(i=cadena.length-1; i>=0; i=cadena.length-1)
    {
        if(cadena.charAt(i)==" ")
            cadena=cadena.substring(0,i);
        else
            break;
    }
    return cadena;
}

function mensaje(msj){
    if(msj.value!=null || msj.value!=''){
        alert(msj);
    }
}