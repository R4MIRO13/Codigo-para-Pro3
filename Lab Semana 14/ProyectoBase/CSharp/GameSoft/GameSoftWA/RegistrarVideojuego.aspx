<%@ Page Title="" Language="C#" MasterPageFile="~/GameSoft.Master" AutoEventWireup="true" CodeBehind="RegistrarVideojuego.aspx.cs" Inherits="GameSoftWA.RegistrarVideojuego" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_Title" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <asp:ScriptManager ID="smContenido" runat="server"/>
    <asp:UpdatePanel id="upContenido" runat="server">
        <ContentTemplate>
            <div class="container">
                <div class="card">
                    <div class="card-header">
                        <h2><asp:Label ID="lblTitulo" runat="server" Text="Registrar Videojuego"></asp:Label></h2>
                    </div>
                    <div class="card-body pb-2">
                        <div class="mb-3 row align-items-center">
                            <asp:Label ID="lblID" runat="server" Text="ID del Videojuego:" CssClass="col-sm-auto pe-sm-2 col-form-label fw-bold" ></asp:Label>
                            <div class="col-sm-2">                        
                                <asp:TextBox ID="txtID" runat="server" CssClass="form-control" Enabled="false" ReadOnly="true"></asp:TextBox>
                            </div>
                        </div>
                        <div class="mb-3 row align-items-center">
                            <asp:Label ID="lblNombre" runat="server" Text="Nombre del Videojuego:" CssClass="col-sm-auto pe-sm-2 col-form-label fw-bold" ></asp:Label>
                            <div class="col-sm-6">                        
                                <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                        <div class="mb-3 row align-items-center">
                            <asp:Label ID="lblGenero" runat="server" Text="Género:" CssClass="col-sm-auto pe-sm-2 col-form-label fw-bold" ></asp:Label>
                            <div class="col-sm-5">
                                <asp:DropDownList ID="ddlGenero" runat="server" CssClass="form-select" AutoPostBack="true"></asp:DropDownList>
                            </div>
                        </div>
                        <div class="mb-3 row align-items-center">
                            <asp:Label ID="lblCategoria" runat="server" Text="Categoria:" CssClass="col-sm-auto pe-sm-2 col-form-label fw-bold" ></asp:Label>
                            <div class="col">
                                <div class="form-control">
                                    <div class="form-check form-check-inline">
                                        <input id="rbAdults" class="form-check-input" type="radio" runat="server" name="categoria"/>
                                        <label id="lblAdults" class="form-check-label" for="cph_Contenido_rbAdults">(A) ADULTS</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input id="rbEveryone" class="form-check-input" type="radio" runat="server" name="categoria"/>
                                        <label id="lblEveryone" class="form-check-label" for="cph_Contenido_rbEveryone">(E) EVERYONE</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input id="rbMature" class="form-check-input" type="radio" runat="server" name="categoria"/>
                                        <label id="lblMature" class="form-check-label" for="cph_Contenido_rbMature">(M) MATURE</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input id="rbTeen" class="form-check-input" type="radio" runat="server" name="categoria"/>
                                        <label id="lblTeen" class="form-check-label" for="cph_Contenido_rbTeen">(T) TEEN</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 row align-items-center">
                            <asp:Label ID="lblFechaLanzamiento" runat="server" Text="Fecha Lanzamiento:" CssClass="col-sm-auto pe-sm-2 col-form-label fw-bold" ></asp:Label>
                            <div class="col-sm-3">
                                <input id="dtpFechaLanzamiento" class="form-control" type="date" runat="server" />
                            </div>
                        </div>
                        <div class="mb-3 row align-items-center">
                            <asp:Label ID="lblPrecio" runat="server" Text="Precio en el Mercado (S/.):" CssClass="col-sm-auto pe-sm-2 col-form-label fw-bold" ></asp:Label>
                            <div class="col-sm-3">                        
                                <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                        <div class="mb-3 row align-items-center">
                            <asp:Label ID="lblNumJugadores" runat="server" Text="Número Max. de Jugadores Permitidos en la Misma Consola:" CssClass="col-sm-auto pe-sm-2 col-form-label fw-bold" ></asp:Label>
                            <div class="col-sm-2">                        
                                <asp:TextBox ID="txtNumJugadores" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <asp:LinkButton ID="lbRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="lbRegresar_Click"/>
                        <asp:LinkButton ID="lbGuardar" runat="server" Text="<i class='fa-regular fa-floppy-disk'></i> Guardar" CssClass="float-end btn btn-primary" />
                    </div>
                </div>
            </div>
        </ContentTemplate>
    </asp:UpdatePanel>
</asp:Content>