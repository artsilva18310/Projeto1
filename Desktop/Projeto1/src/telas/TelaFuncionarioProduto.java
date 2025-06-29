/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package telas;

import apoio.Validacao;
import controladores.ControlaProduto;
import controladores.ControlaFuncionarioProduto;
import entidades.FuncionarioProduto;
import entidades.Funcionario;
import entidades.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import entidades.DAO.FuncionarioProdutoDAO;

/**
 *
 * @author mateus
 */
public class TelaFuncionarioProduto extends javax.swing.JInternalFrame {

    private Funcionario funcionarioSelecionado = null;
    private Produto produtoSelecionado = null;
     private Produto produto = null;
    private ControlaFuncionarioProduto controlaFuncionarioProduto = new ControlaFuncionarioProduto();
     private ControlaProduto controlaProduto = new ControlaProduto();

    /**
     * Creates new form TelaPedidos
     */
    public TelaFuncionarioProduto() {
        initComponents();
        montaTabela();
        
    }

   private void montaTabela() {
    ArrayList<FuncionarioProduto> pps;
    if (produto == null) {
        pps = controlaFuncionarioProduto.recuperarTodos();
    } else {
        pps = controlaFuncionarioProduto.recuperarPorProduto(produto.getId());
    }

    if (pps == null) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar clientes");
    } else {
        tblProdutos.setModel(new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "ID Funcionário";
                    case 1 -> "ID Produto";
                    case 2 -> "Tipo";
                    case 3 -> "Peso";
                    case 4 -> "Ingrediente";
                    case 5 -> "Qtd Estoque";
                    default -> "";
                };
            }

            @Override
            public int getColumnCount() {
                return 6;
            }

            @Override
            public int getRowCount() {
                return pps.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                FuncionarioProduto fp = pps.get(rowIndex);

                if (fp != null) {
                    switch (columnIndex) {
                        case 0:
                            return fp.getIdFuncionario();
                        case 1:
                            return fp.getIdProduto();
                        case 2:
                            return fp.getTipo();        // certifique-se de que existe
                        case 3:
                            return fp.getPeso();        // certifique-se de que existe
                        case 4:
                            return fp.getIngrediente(); // certifique-se de que existe
                        case 5:
                            return fp.getQtdestoque();  // certifique-se de que existe
                    }
                }
                return "n/d";
            }
        });
    } 
} 

       
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProdutos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBuscarProduto = new javax.swing.JButton();
        txtIngrediente = new javax.swing.JTextField();
        txtQtdestoque = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlFuncionario = new javax.swing.JPanel();
        btnBuscarFuncionario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pnlProduto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();

        pnlProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProdutos.setEnabled(false);
        jScrollPane2.setViewportView(tblProdutos);

        btnRemover.setText("-");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAdicionar.setText("+");
        btnAdicionar.setEnabled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        txtID.setEditable(false);

        jLabel8.setText("Produto");

        txtProduto.setEditable(false);

        txtTipo.setEditable(false);

        jLabel9.setText("Peso");

        txtPeso.setEditable(false);
        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        jLabel10.setText("Tipo");

        btnBuscarProduto.setText("Buscar produto");
        btnBuscarProduto.setEnabled(false);
        btnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoActionPerformed(evt);
            }
        });

        txtIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngredienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrediente");

        jLabel3.setText("Estoque");

        javax.swing.GroupLayout pnlProdutosLayout = new javax.swing.GroupLayout(pnlProdutos);
        pnlProdutos.setLayout(pnlProdutosLayout);
        pnlProdutosLayout.setHorizontalGroup(
            pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(pnlProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlProdutosLayout.createSequentialGroup()
                        .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProdutosLayout.createSequentialGroup()
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProdutosLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(19, 19, 19)))
                .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProdutosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQtdestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProdutosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlProdutosLayout.setVerticalGroup(
            pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdutosLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnBuscarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQtdestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        btnBuscarFuncionario.setText("Buscar Funcionario");
        btnBuscarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFuncionarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        txtNome.setEditable(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCargo.setEditable(false);

        jLabel4.setText("Cargo");

        javax.swing.GroupLayout pnlFuncionarioLayout = new javax.swing.GroupLayout(pnlFuncionario);
        pnlFuncionario.setLayout(pnlFuncionarioLayout);
        pnlFuncionarioLayout.setHorizontalGroup(
            pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                .addComponent(btnBuscarFuncionario)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFuncionarioLayout.setVerticalGroup(
            pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarFuncionario)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do pedido"));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        jLabel6.setText("Observação");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProdutoLayout = new javax.swing.GroupLayout(pnlProduto);
        pnlProduto.setLayout(pnlProdutoLayout);
        pnlProdutoLayout.setHorizontalGroup(
            pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProdutoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlProdutoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlProdutoLayout.setVerticalGroup(
            pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel12.setText("Salve o pedido com o cliente para poder adicionar produtos.");

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 384, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pnlProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlProduto.getAccessibleContext().setAccessibleName("Informações do Produto");
        pnlProduto.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFuncionarioActionPerformed
        TelaBuscaDadosFuncionario dlg = new TelaBuscaDadosFuncionario(null, true);
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true);
        funcionarioSelecionado = dlg.getSelecionado();

        if (funcionarioSelecionado != null) {
            txtNome.setText(String.valueOf(funcionarioSelecionado.getNome()));
            txtCargo.setText(funcionarioSelecionado.getCargo());
        } else {
            JOptionPane.showMessageDialog(null, "Funcionario não selecionado.");
        }


    }//GEN-LAST:event_btnBuscarFuncionarioActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
if (Validacao.validarCamposObrigatorios(txtNome, txtCargo,txtTipo,txtPeso,txtQtdestoque,txtIngrediente)) {
        
        Produto fp = new Produto();

fp.setObservacao(txtObservacao.getText());
fp.setFuncioario(funcionarioSelecionado);

boolean sucesso = controlaProduto.salvar(fp);

if (sucesso) {
    JOptionPane.showMessageDialog(null, "Salvo com sucesso");

    tblProdutos.setEnabled(true);
    btnBuscarProduto.setEnabled(true);
    txtTipo.setEditable(true);
    txtPeso.setEditable(true);
    txtQtdestoque.setEditable(true);
    txtIngrediente.setEditable(true);
    btnAdicionar.setEnabled(true);
    btnRemover.setEnabled(true);
} else {
    JOptionPane.showMessageDialog(null, "Ocorreu um erro, verifique os logs.");
}
}
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed

        produtoSelecionado = null;
        produto = null;
        tblProdutos.setEnabled(false);
        btnBuscarProduto.setEnabled(false);
        txtTipo.setEditable(false);
        txtPeso.setEditable(false);
        txtQtdestoque.setEditable(true);
        txtIngrediente.setEditable(true);
        btnAdicionar.setEnabled(false);
        btnRemover.setEnabled(false);
        txtNome.setText("");
        txtCargo.setText("");
        btnFinalizar.setEnabled(false);
        txtObservacao.setText("");
        montaTabela();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed
        TelaBuscaDadosProdutos dlg = new TelaBuscaDadosProdutos(null, true);
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true);
        produtoSelecionado = dlg.getSelecionado();
        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao escolher um produto");
        } else {
            txtID.setText(String.valueOf(produtoSelecionado.getId()));
            txtProduto.setText(produtoSelecionado.getNome());
            txtTipo.setText(produtoSelecionado.getTipo());
            txtPeso.setText(String.valueOf (produtoSelecionado.getPeso()));  
            txtIngrediente.setText(produtoSelecionado.getIngrediente());
            txtQtdestoque.setText(String.valueOf (produtoSelecionado.getQtdestoque()));  
        }
    }//GEN-LAST:event_btnBuscarProdutoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        FuncionarioProduto fp = new FuncionarioProduto();
        fp.setIdFuncionario(funcionarioSelecionado.getIdfuncionario());
        fp.setIdProduto(produtoSelecionado.getId());

        boolean sucesso = controlaFuncionarioProduto.inserir(fp);
        if (sucesso) {
            montaTabela();
            txtNome.setText("");
            txtCargo.setText("");
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int linhaSelecionada = tblProdutos.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idProduto = Integer.parseInt(String.valueOf(tblProdutos.getValueAt(linhaSelecionada, 0)));

            FuncionarioProduto fp = new FuncionarioProduto(
                    funcionarioSelecionado.getIdfuncionario(), idProduto
            );

            controlaFuncionarioProduto.remover(fp);
            montaTabela();
        }

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngredienteActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscarFuncionario;
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlFuncionario;
    private javax.swing.JPanel pnlProduto;
    private javax.swing.JPanel pnlProdutos;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIngrediente;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtdestoque;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    private void permissoes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
