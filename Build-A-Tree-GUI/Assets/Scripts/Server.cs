using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;
using System.Net;
using System.Net.Sockets;

class Server
    {        public String Conectar(String infoToSend)
        {
            Socket socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);

            IPEndPoint miDireccion = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 5000);
            try
            { 
                socket.Connect(miDireccion);

                byte[] infoEnviar = System.Text.Encoding.ASCII.GetBytes(infoToSend);

                socket.Send(infoEnviar, 0, infoEnviar.Length, 0);

                byte[] in_data = new byte[256];
                int count = socket.Receive(in_data);

                string data = System.Text.Encoding.ASCII.GetString(in_data, 0, count);
                socket.Close();
                return data;
            }
            catch (System.Exception)
            {
                return "-1 40"+infoToSend;
            }
        }
    }

