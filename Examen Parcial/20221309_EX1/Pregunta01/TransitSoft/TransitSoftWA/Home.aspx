<%@ Page Title="" Language="C#" MasterPageFile="~/TransitSoft.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="TransitSoftWA.Home" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_Title" runat="server">
    Página Inicial de la Aplicación Web
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <div class="ratio ratio-16x9">
        <iframe src="AsignarVehiculosAPropietario.aspx" title="Asignar Vehiculos A Propietario"></iframe>
        <iframe src="ListarVehiculosDePropietario.aspx" title="Listar Vehiculos De Propietario"></iframe>
    </div>
</asp:Content>
