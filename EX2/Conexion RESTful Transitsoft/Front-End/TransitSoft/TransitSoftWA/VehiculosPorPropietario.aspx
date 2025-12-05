<%@ Page Title="Vehículos por Propietario" MasterPageFile="~/TransitSoft.Master"
Language="C#" AutoEventWireup="true"
CodeBehind="VehiculosPorPropietario.aspx.cs"
Inherits="TransitSoftWA.VehiculosPorPropietario" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">

    <h3>Vehículos por Propietario</h3>

    <asp:Label runat="server" Text="ID Propietario:" />
    <asp:TextBox ID="txtIdPropietario" runat="server" />

    <asp:Button ID="btnBuscar" runat="server" Text="Buscar"
        OnClick="btnBuscar_Click" />

    <br /><br />

    <asp:GridView ID="gvVehiculos" runat="server" AutoGenerateColumns="true" />

</asp:Content>